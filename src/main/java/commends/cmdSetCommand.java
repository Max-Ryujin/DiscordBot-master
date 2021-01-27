package commends;

import core.CommandDB;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class cmdSetCommand implements Command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getAuthor().getIdLong() == 188893043577847808l || event.getAuthor().getIdLong() == 260455062093037568l) {
            String command = args[0];
            String ausgabe = "";
            int l = args.length;
            for(int i = 1; i < l; i++)
            {
                ausgabe+=args[i]+" ";
            }
            System.out.println("c: "+command+" aus: "+ausgabe);
            CommandDB.addCommand(command,ausgabe);
            try {
                CommandDB.save();
                event.getChannel().sendMessage("Command: "+ command +" aktiv").queue();
            }
            catch(Exception ex)
            {
                event.getChannel().sendMessage("something went wr... alles am arsch").queue();
            }

        }
        else
        {
            event.getChannel().sendMessage("Nope").queue();
        }
    }
    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
