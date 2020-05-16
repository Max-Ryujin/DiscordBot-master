package commends;

import core.Leveldb;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class cmdall implements Command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(event.getAuthor().getIdLong() == 188893043577847808l||event.getAuthor().getIdLong() == 260455062093037568l) {
            for (int i = 0; i < Leveldb.members.size(); i++) {
                long userid = Leveldb.members.get(i)[0];
                Member user;
                try {
                    user = event.getGuild().retrieveMemberById(userid).complete();
                } catch (Exception e) {

                    continue;
                }
                event.getChannel().sendMessage(i+1 + ". " + user.getEffectiveName()).queue();
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
