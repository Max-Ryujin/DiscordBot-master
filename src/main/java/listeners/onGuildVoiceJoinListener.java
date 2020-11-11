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

       // if(STATICS.afkmessageid !=0) {
        //    event.getJDA().getGuildById(STATICS.GuildId).getTextChannelById(188893186435973121l).deleteMessageById(STATICS.afkmessageid).complete();
      //  }
       // STATICS.afkmessageid =0;
       // long msid = event.getJDA().getGuildById(STATICS.GuildId).getTextChannelById(188893186435973121l).sendMessage("<:Online:712680947853557850> Bot online").complete().getIdLong();
     //   event.getJDA().getGuildById(STATICS.GuildId).getTextChannelById(188893186435973121l).pinMessageById(msid).complete();

        eb.setTitle("Log",event.getMember().getUser().getAvatarUrl());
        eb.setDescription( event.getMember().getEffectiveName()+" ist in dem Voicechannel "+event.getChannelJoined().getName()+" gegangen um "+ System.currentTimeMillis());

        event.getGuild().getTextChannelsByName("\uD83D\uDCBBbots",false).get(0).sendMessage(eb.build()).queue();
    }
}
