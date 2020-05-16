package listeners;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class readyLIstener extends ListenerAdapter
{
    public void onReady(ReadyEvent event)
    {
        for (Guild g: event.getJDA().getGuilds()
             ) {
            // g.getTextChannels().get(0).sendMessage("Ich bin zurück mit der Version: "+ STATICS.VERSION).queue();

        /*    for (Guild f : event.getJDA().getGuilds()
                 ) {
                for (VoiceChannel v: f.getVoiceChannels()
                ) {
                        System.out.println(v.getName());
                }
            }
*/
        }



    }
}
