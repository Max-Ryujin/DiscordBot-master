package commends;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import utils.STATICS;

public class cmdBlacklist implements Command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        Long id = Long.parseLong(args[0]);
        if(event.getAuthor().getIdLong() == 188893043577847808l||event.getAuthor().getIdLong() == 260455062093037568l) {
            try {
                if (STATICS.blacklist.contains(id)) {
                    STATICS.blacklist.remove(id);
                    event.getChannel().sendMessage("Removed");
                } else {
                    STATICS.blacklist.add(id);
                    event.getChannel().sendMessage("Added");

                }
            }
            catch (Exception e)
            {
                event.getChannel().sendMessage("Something went wrong i can feel it.");
            }
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
