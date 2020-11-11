package commends;

import core.Leveldb;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class cmdall implements Command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        Leveldb.Sortieren();
        if(event.getAuthor().getIdLong() == 188893043577847808l||event.getAuthor().getIdLong() == 260455062093037568l) {

            MessageChannel m = event.getChannel();
            for(Message mm: m.getHistory().retrievePast(100).complete())  // Boosted
            {
                mm.delete().complete();
            }
            for(Message mm: m.getHistory().retrievePast(100).complete())  // Boosted
            {
                mm.delete().complete();
            }
            for (int i = 0; i < Leveldb.members.size(); i++) {
                long userid = Leveldb.members.get(i)[0];
                User user;
                try {
                    Leveldb.Save();
                    user = event.getJDA().retrieveUserById(userid).complete();
                }
                catch(Exception e)
                {
                    user = null;
                }
                if(user != null) {
                    if(event.getGuild().getMember(user) != null) {
                        event.getChannel().sendMessage(i + 1 + ". Level: " + Leveldb.members.get(i)[2] + " | " + user.getName() + " - " + event.getGuild().getMember(user).getEffectiveName()).queue();
                    }
                    else
                    {
                        event.getChannel().sendMessage(i + 1 + ". Level: " + Leveldb.members.get(i)[2] + " | " + user.getName()).queue();
                    }
                }
                else
                {
                    event.getChannel().sendMessage(i + 1 + ". " + userid+"  (Left us a long time ago)").queue();
                }
            }
        }
        else
        {
            event.getChannel().sendMessage("Nööööö").queue();
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
