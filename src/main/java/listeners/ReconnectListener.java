package listeners;

import core.Leveldb;
import core.Log;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.ReconnectedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utils.STATICS;
import utils.VoiceChatMember;
import java.util.LinkedList;

public class ReconnectListener extends ListenerAdapter
{

    public void onReconnect(ReconnectedEvent event)
    {
        System.out.println("RECONNECT");
        Guild g = event.getJDA().getGuildById(STATICS.GuildId);
        LinkedList<Long> list = new LinkedList<Long>();
        g.getTextChannels().get(0).deleteMessageById(STATICS.afkchannelid).complete();
        String Sprecher = "Sprecher: ";
        String Old_Sprecher = "Old_Sprecher: ";
        for (VoiceChannel v:
        g.getVoiceChannels()) {
            for (Member m:
                v.getMembers() ) {
                list.add(m.getIdLong());
                Sprecher += m.getEffectiveName()+"\n";
            }

        }
        Log.Message(event.getJDA(),Sprecher);
        for(VoiceChatMember v : STATICS.speakingMember)
        {
            boolean isthere = false;
            for(long l: list)
            {
                if(l == v.Getid())
                {
                    isthere = true;
                    list.remove(l);
                    Old_Sprecher+= event.getJDA().getGuildById(STATICS.GuildId).getMemberById(l).getEffectiveName();
                }
            }
            if(!isthere)
            {
                long XP = (long) ((v.getspeakingTime()/60000.0)*(30*(5/Math.sqrt(Leveldb.getLevel(v.Getid())+10))-12));

                Leveldb.addXP(v.Getid(),XP,event.getJDA());
                STATICS.speakingMember.remove(v);
                Log.Message(event.getJDA(),event.getJDA().getGuildById(STATICS.GuildId).getMemberById(v.Getid()).getEffectiveName()+"ist weg "+XP);
            }
        }
        Log.Message(event.getJDA(),Old_Sprecher);
        for(long l: list)
        {
            VoiceChatMember v = new VoiceChatMember(l);
            STATICS.speakingMember.add(v);
            Log.Message(event.getJDA(),event.getJDA().getGuildById(STATICS.GuildId).getMemberById(v.Getid()).getEffectiveName()+"ist Neu ");
        }

    }
}
