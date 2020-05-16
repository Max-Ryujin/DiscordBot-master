package core;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Perms {

    public static boolean checkchannel(MessageReceivedEvent event)
    {
        if(event.getTextChannel()==event.getGuild().getTextChannelsByName("general",false).get(0))
        {
            return false;
        }
        else{return true;}
    }
}