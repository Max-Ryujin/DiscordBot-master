package listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class guildjoinListener extends ListenerAdapter {
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.blue);
        eb.setTitle("Willkommen",event.getMember().getUser().getAvatarUrl());
        eb.setDescription( event.getMember().getEffectiveName()+" ist bei uns eingetroffen\n wenn du Hilfe brauchst verwende -help \n");

        event.getGuild().getTextChannels().get(0).sendMessage(eb.build()).queue();

    }
}
