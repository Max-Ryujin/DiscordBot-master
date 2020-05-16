package core;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import utils.STATICS;

import java.awt.*;

public class Log {

    public static void Message(JDA jda,String Message)
    {
        System.out.println("Build Log: "+Message);
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.blue);

        eb.setTitle("Log");
        eb.setDescription(Message);

        jda.getGuildById(STATICS.GuildId).getTextChannelsByName("\uD83D\uDCBBbots",false).get(0).sendMessage(eb.build()).queue();
    }
}
