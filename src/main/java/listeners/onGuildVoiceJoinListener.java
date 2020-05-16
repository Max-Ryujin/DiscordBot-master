package listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utils.STATICS;
import utils.VoiceChatMember;

import java.awt.*;

public class onGuildVoiceJoinListener extends ListenerAdapter {
    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {

        long id = event.getMember().getUser().getIdLong();
        STATICS.speakingMember.add(new VoiceChatMember(id));

        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.blue);

        eb.setTitle("Log",event.getMember().getUser().getAvatarUrl());
        eb.setDescription( event.getMember().getEffectiveName()+" ist in dem Voicechannel "+event.getChannelJoined().getName()+" gegangen um "+ System.currentTimeMillis());

        event.getGuild().getTextChannelsByName("\uD83D\uDCBBbots",false).get(0).sendMessage(eb.build()).queue();
    }
}
