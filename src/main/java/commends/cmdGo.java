package commends;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmdGo implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.blue);
        eb.setTitle("Go-Baduk","https://de.wikipedia.org/wiki/Go_(Spiel)");
        eb.addField("Tutorial","https://www.youtube.com/watch?v=1H0j1cVItBs&list=PL8NaUi1LMQ2tncyvTUKpwpVz29WVWPDX8",false);
        eb.addField("Spielen","https://online-go.com/",false);
        event.getTextChannel().sendMessage(eb.build()).queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
