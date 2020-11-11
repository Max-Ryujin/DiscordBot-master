package core;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.Role;

import java.io.*;
import java.util.ArrayList;

public class MessageDB {

  public static ArrayList<long[]> Messages = new ArrayList<>();


    public MessageDB() throws IOException {
        File file = new File("Message.txt");
        if(!file.exists())
        {
            PrintWriter creator = new PrintWriter("Message.txt");
            creator.close();
        }
        FileReader fr = new FileReader("Message.txt");
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

            Messages.add(inputs2);
        }
        br.close();
        System.out.println(Messages.size());
    }

    static public void addMessage(Message m)
    {
        long[] x = new long[3];
        x[0] = m.getIdLong();
        Messages.add(x);
    }


    static public void addReaktion(Message m, MessageReaction.ReactionEmote emote)
    {
        for (long[] l: Messages
             ) {
            if(l[0] == m.getIdLong())
            {
                l[1] = emote.getIdLong();

            }
        }
    }

    static public void addRole(Message m, Role r)
    {
        for (long[] l: Messages
        ) {
            if(l[0] == m.getIdLong())
            {
                l[2] = r.getIdLong();

            }
        }
    }

    static public void save() throws IOException
    {
        File datei = new File("Message.txt");
        FileWriter fw = new FileWriter(datei);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("");
        for (long[] x: Messages)
        {
            bw.write(x[0]+";"+x[1]+";"+x[2]+";");
            bw.newLine();
        }
        bw.close();
    }
}
