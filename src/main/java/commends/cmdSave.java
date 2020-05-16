package commends;

import core.Leveldb;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class cmdSave implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
       try
       {
           Leveldb.Save();
           event.getTextChannel().sendMessage("saved").queue();
       }
       catch (Exception e)
       {
         event.getTextChannel().sendMessage("Achtung fehler").queue();
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
