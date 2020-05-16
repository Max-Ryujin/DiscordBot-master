package commends;

import core.Leveldb;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class cmdSetLvl implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(event.getAuthor().getIdLong() == 188893043577847808l||event.getAuthor().getIdLong() == 260455062093037568l)
        {
            int l = args.length;
            String username = args[0];
            if(l>2) {
                for (int i = 1; i <= l - 2; i++) {
                    username += " " + args[i];
                }
            }
            User nutzer = event.getGuild().getMembersByName(username,false).get(0).getUser();
            try {
               if(Leveldb.Testexists(nutzer.getIdLong()))
               {
                   Leveldb.SetLevel(nutzer.getIdLong(),Integer.parseInt(args[l-1]));
                   event.getChannel().sendMessage("changed lvl").queue();
               }
            }
            catch(Exception e)
            {
                event.getChannel().sendMessage("Something went wrong i can feel it("+e.toString()+")").queue();
            }
        }
        else
        {
            event.getChannel().sendMessage("Netter Versuch du Hobby Cheater").queue();
        }
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
