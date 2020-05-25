package listeners;

import core.Leveldb;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utils.STATICS;
import utils.VoiceChatMember;

import java.awt.*;

public class onGuildVoiceLeaveListener extends ListenerAdapter {
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {

        long id = event.getMember().getUser().getIdLong();
        long spendTime = 6000;

        for(int i = 0; i< STATICS.speakingMember.size();i++)
        {
            VoiceChatMember x = STATICS.speakingMember.get(i);
            if(id == x.Getid())
            {
                spendTime = x.getspeakingTime();
                STATICS.speakingMember.remove(i);
                break;
            }
        }
        try {
            if (!(Leveldb.Testexists(id))) {
                Leveldb.newMember(id);
            }
        }
        catch(Exception e)
        {
            event.getGuild().getTextChannels().get(0).sendMessage("Ups something went wrong i can feel it").queue();
        }
        long Levelvor = Leveldb.getLevel(id);
        long XP;

        XP = (long) ((spendTime/120000.0)*(28*(5/Math.sqrt(Levelvor+10))-12));

        if(!STATICS.blacklist.contains(id)) {

            Leveldb.addXP(id, XP, event.getJDA());
        }

        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("LOG");
        eb.setColor(Color.blue);
        eb.addField("Log","User "+event.getMember().getEffectiveName()+" left the voicechannel "+event.getChannelLeft().getName()+" after "+ spendTime/1000+"seconds and got "+XP+" XP",false);
        event.getGuild().getTextChannelsByName("\uD83D\uDCBBbots",false).get(0).sendMessage(eb.build()).queue();

    }
}