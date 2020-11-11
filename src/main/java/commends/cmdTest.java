package commends;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class cmdTest implements Command {
    long id;
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        try {
            if (event.getAuthor().getIdLong() == 260455062093037568l) {

            } else {
                event.getChannel().sendMessage("Sorry aber der ist nur für mich zum testen probier was anderes");
            }
        }
        catch(Exception e)
        {
            event.getChannel().sendMessage(e.toString());
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
