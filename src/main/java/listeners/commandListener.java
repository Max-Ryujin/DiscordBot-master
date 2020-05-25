package listeners;

import core.Leveldb;
import core.commandHandler;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import utils.STATICS;

import java.io.IOException;

public class commandListener extends ListenerAdapter
{
    public void onMessageReceived(MessageReceivedEvent event)
    {
       String Befehl = event.getMessage().getContentRaw().toLowerCase();
        try {
            long Avatarid = event.getAuthor().getIdLong();
            if(!(Leveldb.Testexists(Avatarid)))
            {
                Leveldb.newMember(Avatarid);
            }
                long Levelvor = Leveldb.getLevel(Avatarid);
                long XP;

                if(event.getTextChannel().getName().equals("\uD83D\uDCC8xp-farm"))
                {
                     XP = (long) (20*(5/Math.sqrt(Levelvor+10))-11);
                }
                else
                {
                    XP = (long) (30*(5/Math.sqrt(Levelvor+10))-12);
                }
            if(!STATICS.blacklist.contains(Avatarid)) {

                Leveldb.addXP(Avatarid, XP, event.getJDA());
            }

        }
        catch (IOException e) {

        }

       if(Befehl.startsWith(STATICS.PREFIX) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId())
       {
           commandHandler.handleCommand(commandHandler.parser.parse(event.getMessage().getContentRaw(), event));
       }
    }
}
