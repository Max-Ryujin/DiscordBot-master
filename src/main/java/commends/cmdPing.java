package commends;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmdPing implements Command
{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event)
    {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.blue);
        eb.setTitle("pong!","http://stewd.io/pong/");
        event.getTextChannel().sendMessage(eb.build()).queue();


    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {
     System.out.println("[INFO] Command ping wurde ausgeführt");
    }

    @Override
    public String help() {
        return null;
    }
}
