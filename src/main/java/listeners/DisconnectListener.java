package listeners;

import net.dv8tion.jda.api.events.DisconnectEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DisconnectListener extends ListenerAdapter
{
    public void onDisconnect(DisconnectEvent event)
    {
      //  if(STATICS.afkmessageid ==0) {
        //    STATICS.afkmessageid = event.getJDA().getGuildById(STATICS.GuildId).getTextChannelById(188893186435973121l).sendMessage("<:Offline:712680947505692704> Bot offline").complete().getIdLong();
          //  event.getJDA().getGuildById(STATICS.GuildId).getTextChannelById(188893186435973121l).pinMessageById(STATICS.afkmessageid).complete();
       // }
    }
}
