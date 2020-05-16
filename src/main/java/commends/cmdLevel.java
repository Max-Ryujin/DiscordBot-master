package commends;

import core.Leveldb;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmdLevel implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        long Avatarid = event.getAuthor().getIdLong();
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.blue);
        eb.setDescription("Dein Level: "+ Leveldb.getLevel(Avatarid)+"\n Deine XP: "+Leveldb.getXP(Avatarid));
        eb.setThumbnail(event.getAuthor().getAvatarUrl());
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
