package commends;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmdChess implements  Command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.ORANGE);
        eb.setTitle("StudeGaming Chess Tournament","https://studegaming.jimdofree.com/schach-turnier/");
        eb.addField("Datum","09.01.2021",false);
        eb.addField("Anmeldung","https://studegaming.jimdofree.com/schach-turnier/",false);
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
