package listeners;

import core.Leveldb;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utils.STATICS;
import utils.VoiceChatMember;

import java.awt.*;

public class onGuildVoiceLeaveListener extends ListenerAdapter {
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {

        long id = event.getMember().getUser().getIdLong();
        long spendTime = 60000;

        for(int i = 0; i< STATICS.speakingMember.size();i++)
        {
            VoiceChatMember x = STATICS.speakingMember.get(i);
            if(id == x.Getid())
            {
                spendTime = x.getspeakingTime();
                STATICS.speakingMember.remove(i);
                break;
            }
        }
        try {
            if (!(Leveldb.Testexists(id))) {
                Leveldb.newMember(id);
            }
        }
        catch(Exception e)
        {
            event.getGuild().getTextChannels().get(0).sendMessage("Ups something went wrong i can feel it").queue();
        }
        long Levelvor = Leveldb.getLevel(id);
        long XP;

        XP = (long) ((spendTime/120000.0)*(28*(5/Math.sqrt(Levelvor+10))-12));

        Leveldb.addXP(id,XP,event.getJDA());

      //  int lvl = (int)Leveldb.getLevel(id);

        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("LOG");
        eb.setColor(Color.blue);
        eb.addField("Log","User "+event.getMember().getEffectiveName()+" left the voicechannel "+event.getChannelLeft().getName()+" after "+ spendTime/1000+"seconds and got "+XP+" XP",false);
        event.getGuild().getTextChannelsByName("\uD83D\uDCBBbots",false).get(0).sendMessage(eb.build()).queue();

    /*    if(Levelvor != lvl)
        {
            String ReturnString;
            String SpezialReturnString;
            switch (lvl)
            {
                case 1:
                    Role lvl1 = event.getGuild().getRolesByName("\uD83D\uDD18Member",false).get(0);
                    if(lvl1 == null ) {System.out.println("Role CM does not exist");}
                    event.getGuild().addRoleToMember(event.getGuild().getMember(event.getMember().getUser()), lvl1).complete();
                    SpezialReturnString = "Glückwunsch du bist jetzt Member";
                case 10:
                    Role lvl10 = event.getGuild().getRolesByName("✅Certified-Member",false).get(0);
                    if(lvl10 == null ) {System.out.println("Role CM does not exist");}
                    event.getGuild().addRoleToMember(event.getGuild().getMember(event.getMember().getUser()), lvl10).complete();
                    SpezialReturnString = "Glückwunsch du bist jetzt ✅Certified-Member";
                    break;
                case 20:
                    Role lvl20 = event.getGuild().getRolesByName("\uD83D\uDD30Premium-Member",false).get(0);
                    event.getGuild().addRoleToMember(event.getGuild().getMember(event.getMember().getUser()), lvl20).complete();
                    SpezialReturnString = "Glückwunsch du bist jetzt Premium-Member";
                    break;
                case 30:
                    Role lvl30 = event.getGuild().getRolesByName("\uD83C\uDF0CSupreme-Member",false).get(0);
                    event.getGuild().addRoleToMember(event.getGuild().getMember(event.getMember().getUser()), lvl30).complete();
                    SpezialReturnString = "Glückwunsch du bist jetzt Supreme-Member";
                    break;
                case 40:
                    Role lvl40 = event.getGuild().getRolesByName("\uD83D\uDCAFElder",false).get(0);
                    event.getGuild().addRoleToMember(event.getGuild().getMember(event.getMember().getUser()), lvl40).complete();
                    SpezialReturnString = "Glückwunsch du nun Elder";
                    break;
                case 50:
                    Role lvl50 = event.getGuild().getRolesByName("\uD83D\uDCAFSpartan",false).get(0);
                    event.getGuild().addRoleToMember(event.getGuild().getMember(event.getMember().getUser()), lvl50).complete();
                    SpezialReturnString = "Glückwunsch du nun Spartan";
                case 65:
                    Role lvl65 = event.getGuild().getRolesByName("\uD83D\uDD25Grand-Master",false).get(0);
                    event.getGuild().addRoleToMember(event.getGuild().getMember(event.getMember().getUser()), lvl65).complete();
                    SpezialReturnString = "Glückwunsch du nun GrandMaster";
                    break;
                case 80:
                    Role lvl80 = event.getGuild().getRolesByName("\uD83D\uDC51VIP",false).get(0);
                    event.getGuild().addRoleToMember(event.getGuild().getMember(event.getMember().getUser()), lvl80).complete();
                    SpezialReturnString = "Glückwunsch du nun VIP";

                    break;
                case 100:

                    Role lvl100 = event.getGuild().getRolesByName("⚜️GOD",false).get(0);
                    event.getGuild().addRoleToMember(event.getGuild().getMember(event.getMember().getUser()), lvl100).complete();
                    SpezialReturnString = "Glückwunsch du jetzt God";
                    break;


                default:   SpezialReturnString = "Auf gehts!";
                    break;
            }
            EmbedBuilder eb2 = new EmbedBuilder();
            eb2.setTitle("LEVELUP");
            eb2.setThumbnail(event.getMember().getUser().getAvatarUrl());
            eb2.setColor(Color.green);
            eb2.addField("","Glückwunsch "+event.getMember().getUser().getName()+"\n du hast Level "+lvl+"  erreicht",false);
            eb2.addField("",SpezialReturnString,false);
            event.getGuild().getTextChannels().get(0).sendMessage(eb2.build()).queue();


        }
         */

    }
}