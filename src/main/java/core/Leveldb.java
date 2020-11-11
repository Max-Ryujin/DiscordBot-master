package core;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import utils.STATICS;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Leveldb {

  public static ArrayList<long[]> members = new ArrayList<>();


    public Leveldb() throws IOException {
        File file = new File("Level.txt");
        if(!file.exists())
        {
            PrintWriter creator = new PrintWriter("Level.txt");
            creator.close();
        }
        FileReader fr = new FileReader("Level.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null)
        {
            String[] inputs = new String[3];
            String input = line;
            inputs = input.split(";");
            long[] inputs2 = new long[3];
            inputs2[0] = Long.parseLong(inputs[0]);
            inputs2[1] = Long.parseLong(inputs[1]);
            inputs2[2] = Long.parseLong(inputs[2]);
            members.add(inputs2);
        }
        br.close();
        System.out.println(members.size());
    }


   static public void newMember(long Avatarid)
     {
         long[] eingabe = new long[3];
         eingabe[0] = Avatarid;
         eingabe[1] = 0;
         eingabe[2] = 0;
       members.add(eingabe);
     }

   static public void addXP(long Avatarid,long xp,JDA jda)
    {
        for (long[] x: members)
        {
           if(x[0]==Avatarid)
           {
               x[1]+= xp;
               while(x[1]>= 1000)
               {

                   x[1]-=1000;
                   x[2]++;
                   Levelup(x[2],x[0],jda);
               }
           }
        }
    }

   static public long getLevel(long Avatarid)
    {
        for (long[] x: members)
        {
            if(x[0]==Avatarid)
            {
              return x[2];
            }
        }
        return -1;
    }

    static public void SetLevel(long Avatarid,int lvl)
    {
        for (long[] x: members)
        {
            if(x[0]==Avatarid)
            {
                x[2] = lvl;
            }
        }

    }

   static public long getXP(long Avatarid)
    {
        for (long[] x: members)
        {
            if(x[0]==Avatarid)
            {
                return x[1];
            }
        }
        return -1;
    }
    static public boolean Testexists(long Avatarid) throws IOException
    {
        for (long x[] : members)
        {
            if(Avatarid == x[0])
            {
                return true;
            }
        }
        return false;
    }

   static public void Save() throws IOException
    {
        File datei = new File("Level.txt");
        FileWriter fw = new FileWriter(datei);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("");
        for (long[] x: members)
        {
         bw.write(x[0]+";"+x[1]+";"+x[2]+";");
         bw.newLine();
        }
        bw.close();
    }


    public static EmbedBuilder Levelup(long lvl, long id, JDA jda)
    {
        int level = (int) lvl;
        String ReturnString;
        String SpezialReturnString;
        Guild g = jda.getGuildById(STATICS.GuildId);
        switch (level)
        {
            case 1:

                Role lvl1 = g.getRolesByName("\uD83D\uDD18Member",false).get(0);
                if(lvl1 == null ) {System.out.println("Role M does not exist");}
                g.addRoleToMember(g.getMemberById(id), lvl1).complete();
                SpezialReturnString = "Glückwunsch du bist jetzt Member";
                break;
            case 10:
                Role lvl10 = g.getRolesByName("✅Certified-Member",false).get(0);
                if(lvl10 == null ) {System.out.println("Role CM does not exist");}
                g.addRoleToMember(g.getMemberById(id), lvl10).complete();
                SpezialReturnString = "Glückwunsch du bist jetzt ✅Certified-Member";
                break;
            case 20:
                Role lvl20 = g.getRolesByName("\uD83D\uDD30Premium-Member",false).get(0);
                g.addRoleToMember(g.getMemberById(id), lvl20).complete();
                SpezialReturnString = "Glückwunsch du bist jetzt Premium-Member";
                break;
            case 30:
                Role lvl30 = g.getRolesByName("\uD83C\uDF0CSupreme-Member",false).get(0);
                g.addRoleToMember(g.getMemberById(id), lvl30).complete();
                SpezialReturnString = "Glückwunsch du bist jetzt Supreme-Member";
                break;
            case 40:
                Role lvl40 = g.getRolesByName("\uD83D\uDCAFElder",false).get(0);
                g.addRoleToMember(g.getMemberById(id), lvl40).complete();
                SpezialReturnString = "Glückwunsch du nun Elder";
                break;
            case 50:
                Role lvl50 = g.getRolesByName("\uD83D\uDCAFSpartan",false).get(0);
                g.addRoleToMember(g.getMemberById(id), lvl50).complete();
                SpezialReturnString = "Glückwunsch du nun Spartan";
                break;
            case 65:
                Role lvl65 = g.getRolesByName("\uD83D\uDD25Grand-Master",false).get(0);
                g.addRoleToMember(g.getMemberById(id), lvl65).complete();
                SpezialReturnString = "Glückwunsch du nun GrandMaster";

                break;
            case 80:
                Role lvl80 = g.getRolesByName("\uD83D\uDC51VIP",false).get(0);
                g.addRoleToMember(g.getMemberById(id), lvl80).complete();
                SpezialReturnString = "Glückwunsch du bist nun VIP";

                break;
            case 100:

                Role lvl100 = g.getRolesByName("⚜️GOD",false).get(0);
                g.addRoleToMember(g.getMemberById(id), lvl100).complete();
                SpezialReturnString = "Glückwunsch du bist nun GOD";
                break;

            default:   SpezialReturnString = "Auf gehts!";
                break;
        }
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("LEVELUP");
        eb.setColor(Color.green);
        eb.addField("","Glückwunsch "+g.getMemberById(id).getEffectiveName()+"\n du hast Level "+level+"  erreicht",false);
        eb.addField("",SpezialReturnString,false);
        jda.getGuildById(STATICS.GuildId).getTextChannelById(188893186435973121l).sendMessage(eb.build()).queue();
        return eb;
    }

    public static EmbedBuilder Levelup(long lvl, MessageReceivedEvent event)
    {
        int level = (int) lvl;
        String ReturnString;
        String SpezialReturnString;
        switch (level)
        {
            case 1:
                Role lvl1 = event.getGuild().getRolesByName("\uD83D\uDD18Member",false).get(0);
                if(lvl1 == null ) {System.out.println("Role M does not exist");}
                event.getGuild().addRoleToMember(event.getGuild().getMember(event.getAuthor()), lvl1).complete();
                SpezialReturnString = "Glückwunsch du bist jetzt Member";
                break;
            case 10:
                Role lvl10 = event.getGuild().getRolesByName("✅Certified-Member",false).get(0);
                if(lvl10 == null ) {System.out.println("Role CM does not exist");}
                event.getGuild().addRoleToMember(event.getGuild().getMember(event.getAuthor()), lvl10).complete();
                SpezialReturnString = "Glückwunsch du bist jetzt ✅Certified-Member";
                break;
            case 20:
                Role lvl20 = event.getGuild().getRolesByName("\uD83D\uDD30Premium-Member",false).get(0);
                event.getGuild().addRoleToMember(event.getGuild().getMember(event.getAuthor()), lvl20).complete();
                SpezialReturnString = "Glückwunsch du bist jetzt Premium-Member";
                break;
            case 30:
                Role lvl30 = event.getGuild().getRolesByName("\uD83C\uDF0CSupreme-Member",false).get(0);
                event.getGuild().addRoleToMember(event.getGuild().getMember(event.getAuthor()), lvl30).complete();
                SpezialReturnString = "Glückwunsch du bist jetzt Supreme-Member";
                break;
            case 40:
                Role lvl40 = event.getGuild().getRolesByName("\uD83D\uDCAFElder",false).get(0);
                event.getGuild().addRoleToMember(event.getGuild().getMember(event.getAuthor()), lvl40).complete();
                SpezialReturnString = "Glückwunsch du nun Elder";
                break;
            case 50:
                Role lvl50 = event.getGuild().getRolesByName("\uD83D\uDCAFSpartan",false).get(0);
                event.getGuild().addRoleToMember(event.getGuild().getMember(event.getAuthor()), lvl50).complete();
                SpezialReturnString = "Glückwunsch du nun Spartan";
                break;
            case 65:
                Role lvl65 = event.getGuild().getRolesByName("\uD83D\uDD25Grand-Master",false).get(0);
                event.getGuild().addRoleToMember(event.getGuild().getMember(event.getAuthor()), lvl65).complete();
                SpezialReturnString = "Glückwunsch du nun GrandMaster";

                break;
            case 80:
                Role lvl80 = event.getGuild().getRolesByName("\uD83D\uDC51VIP",false).get(0);
                event.getGuild().addRoleToMember(event.getGuild().getMember(event.getAuthor()), lvl80).complete();
                SpezialReturnString = "Glückwunsch du bist nun VIP";

                break;
            case 100:

                Role lvl100 = event.getGuild().getRolesByName("⚜️GOD",false).get(0);
                event.getGuild().addRoleToMember(event.getGuild().getMember(event.getAuthor()), lvl100).complete();
                SpezialReturnString = "Glückwunsch du bist nun GOD";
                break;

            default:   SpezialReturnString = "Auf gehts!";
                break;
        }
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("LEVELUP");
        eb.setThumbnail(event.getAuthor().getAvatarUrl());
        eb.setColor(Color.green);
        eb.addField("","Glückwunsch "+event.getAuthor().getName()+"\n du hast Level "+level+"  erreicht",false);
        eb.addField("",SpezialReturnString,false);
        return eb;
    }


    public static void Sortieren() {
        int highestXP;
        ArrayList<long[]> totalXP = new ArrayList<>();
        for (long[] l : members) {
            long[] hi = new long[3];
            hi[0] = l[0];
            hi[1] = l[1] ;
            hi[2] = l[2]* 1000 + l[1];
            totalXP.add(hi);
        }

        ArrayList<long[]> sortScores = new ArrayList<>();
        while (totalXP.size() != 0) {
            highestXP = 0;
            for (int i = 0; i < totalXP.size(); i++) {
                if (totalXP.get(i)[2] > totalXP.get(highestXP)[2]) {
                    highestXP = i;
                }
            }
            sortScores.add(totalXP.get(highestXP));
            totalXP.remove(highestXP);
        }
        members.clear();
        for (long[] l : sortScores) {
            long[] hi = new long[3];
            hi[0] = l[0];
            hi[1] = l[1];
            hi[2] = l[2] / 1000;

            members.add(hi);
        }
    }
}
