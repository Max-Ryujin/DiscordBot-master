package listeners;


import core.Leveldb;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utils.STATICS;
import utils.VoiceChatMember;

import java.awt.*;

public class onGuildVoiceMoveListener extends ListenerAdapter {
    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {
        if (event.getNewValue().getIdLong() == STATICS.afkchannelid)
        {
            long id = event.getMember().getIdLong();
            long spendTime = 6000;

            for (int i = 0; i < STATICS.speakingMember.size(); i++) {
                VoiceChatMember x = STATICS.speakingMember.get(i);
                if (id == x.Getid()) {
                    spendTime = x.getspeakingTime();
                    STATICS.speakingMember.remove(i);
                    break;
                }
            }

            System.out.println(id + " Moved");
            long Levelvor = Leveldb.getLevel(id);
            long XP;

            XP = (long) ((spendTime / 120000.0) * (28 * (5 / Math.sqrt(Levelvor + 10)) - 12));

            Leveldb.addXP(id, XP,event.getJDA());

            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("LOG");

            eb.setColor(Color.blue);
            eb.addField("Log", "User " +event.getMember().getEffectiveName()+ " left the voicechannel " + event.getChannelLeft().getName() + " after " + spendTime/1000 + "seconds and got " + XP + " XP", false);
            event.getGuild().getTextChannelsByName("\uD83D\uDCBBbots", false).get(0).sendMessage(eb.build()).queue();
        }
        else if(event.getChannelLeft().getIdLong() == STATICS.afkchannelid)
        {
            long id = event.getMember().getUser().getIdLong();
            STATICS.speakingMember.add(new VoiceChatMember(id));

            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.blue);

            eb.setTitle("Log",event.getMember().getUser().getAvatarUrl());
            eb.setDescription( event.getMember().getEffectiveName()+" ist in dem Voicechannel "+event.getChannelJoined().getName()+" gegangen um "+ System.currentTimeMillis());

            event.getGuild().getTextChannelsByName("\uD83D\uDCBBbots",false).get(0).sendMessage(eb.build()).queue();
        }

    }
}
