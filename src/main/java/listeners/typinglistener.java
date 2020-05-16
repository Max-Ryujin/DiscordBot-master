package listeners;

import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class typinglistener extends ListenerAdapter {

    public void onUserTyping(UserTypingEvent event)
    {
        Random r = new Random();

        if( r.nextInt(40) == 1)
        {
         //   event.getChannel().sendMessage("shut up " + event.getMember().getEffectiveName()).queue();

        }
    }
}
