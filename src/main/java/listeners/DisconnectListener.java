package listeners;

import net.dv8tion.jda.api.events.DisconnectEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utils.STATICS;

public class DisconnectListener extends ListenerAdapter
{
    public void onDisconnect(DisconnectEvent event)
    {
        STATICS.afkmessageid = event.getJDA().getGuildById(STATICS.GuildId).getTextChannelById(188893186435973121l).sendMessage(":Offline:Bot offline").complete().getIdLong();

    }
}
