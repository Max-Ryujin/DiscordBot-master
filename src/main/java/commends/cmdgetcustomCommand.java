package commends;

import core.CommandDB;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class cmdgetcustomCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        String ausgabe = "";
        for (String[] s: CommandDB.Commands
             ) {
                ausgabe+=s[0]+" \n";
        }
        event.getChannel().sendMessage(ausgabe).queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
