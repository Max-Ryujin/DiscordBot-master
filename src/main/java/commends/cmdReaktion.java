package commends;

import core.MessageDB;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class cmdReaktion implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        Message m = event.getChannel().retrieveMessageById(args[0]).complete();
        MessageDB.addMessage(m);
        MessageReaction.ReactionEmote reakt = m.getReactions().get(0).getReactionEmote();
        MessageDB.addReaktion(m,reakt);
        Role r =  event.getGuild().getRoleById(args[1]);
        MessageDB.addRole(m,r);
        try {
            MessageDB.save();
        }
        catch(Exception ex)
        {

        }

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {
        event.getMessage().delete().queue();
    }

    @Override
    public String help() {
        return null;
    }
}
