package commends;

import core.Leveldb;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import utils.STATICS;
import utils.VoiceChatMember;

import java.awt.*;

public class cmdGetSpeaker implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        try
        {
            Leveldb.Save();
        }
        catch(Exception e)
        {

        }

        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.MAGENTA);
                for(VoiceChatMember v: STATICS.speakingMember)
                {
                    eb.addField(event.getGuild().getMemberById(v.Getid()).getEffectiveName(),(v.getspeakingTime()/1000.0)+"",false);
                }
                event.getChannel().sendMessage(eb.build()).queue();

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
