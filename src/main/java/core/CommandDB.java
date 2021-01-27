package core;

import java.io.*;
import java.util.ArrayList;

public class CommandDB {

  public static ArrayList<String[]> Commands = new ArrayList<>();


    public CommandDB() throws IOException {
        File file = new File("Command.txt");
        if(!file.exists())
        {
            PrintWriter creator = new PrintWriter("Command.txt");
            creator.close();
        }
        FileReader fr = new FileReader("Command.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null)
        {
            String[] inputs = new String[2];
            String input = line;
            inputs = input.split(";");
            String[] inputs2 = new String[2];
            inputs2[0] = inputs[0];
            inputs2[1] = inputs[1];

            Commands.add(inputs2);
        }
        br.close();
        System.out.println(Commands.size());
    }

    static public void addCommand(String command,String anser)
    {
        if(commandexists(command))
        {
            for (String[] s: Commands
            ) {
                if(s[0].equals(command))
                {
                   s[1] = anser;
                }
            }
        }
        else {
            String[] x = new String[3];
            x[0] = command;
            x[1] = anser;
            Commands.add(x);
        }
    }

    static boolean commandexists(String command)
    {
        for (String[] s: Commands
        ) {
            if(s[0].equals(command))
            {
               return true;
            }
        }
        return false;
    }

    static public String getCommand(String command)
    {
        String ausgabe = "Dieser Command existiert nicht";
        for (String[] s: Commands
             ) {
            if(s[0].equals(command))
            {
                ausgabe = s[1];
            }
        }
        return ausgabe;
    }
    
    static public void save() throws IOException
    {
        File datei = new File("Command.txt");
        FileWriter fw = new FileWriter(datei);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("");
        for (String[] x: Commands)
        {
            bw.write(x[0]+";"+x[1]+";");
            bw.newLine();
        }
        bw.close();
    }
}
