package commends;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmdNew implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {


        event.getTextChannel().sendMessage(New(event.getGuild()).build()).queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }

    public static EmbedBuilder New(Guild g)
    {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.ORANGE);
        eb.setThumbnail(g.getJDA().getSelfUser().getAvatarUrl());

        eb.addField("Version 3.0.0","Big Changes, Bla bla bla . You will See.",false);
        return eb;
    }
}
