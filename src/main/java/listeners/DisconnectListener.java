package listeners;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.DisconnectEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DisconnectListener extends ListenerAdapter
{
    public void onDisconnect(DisconnectEvent event)
    {
        for (Guild g : event.getJDA().getGuilds())
        {
            g.getTextChannelsByName("\uD83D\uDCBBbots",false).get(0).sendMessage("ich bin bald wieder zurück, wenn nicht beschwert euch bei Ryujin").queue();
        }
    }
}
