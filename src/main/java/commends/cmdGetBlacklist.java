package commends;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import utils.STATICS;

public class cmdGetBlacklist implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        for (Long l :STATICS.blacklist
             ) {
            event.getChannel().sendMessage(event.getGuild().getMemberById(l).getEffectiveName()).queue();
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
