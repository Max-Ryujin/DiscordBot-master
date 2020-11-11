package commends;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class cmdSend implements Command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(event.getAuthor().getIdLong() == 188893043577847808l||event.getAuthor().getIdLong() == 260455062093037568l) {
            if(args.length>=1) {
                String string = " ";
                for (String ss : args
                ) {
                    string += ss+" ";
                }
                String finalString = string;
                event.getGuild().getTextChannelById(188893186435973121l).sendMessage(finalString).queue();
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
