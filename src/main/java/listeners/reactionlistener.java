package listeners;

import core.MessageDB;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.react.GenericGuildMessageReactionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class reactionlistener extends ListenerAdapter {

    public void onGenericGuildMessageReaction(@Nonnull GenericGuildMessageReactionEvent event)
    {
        MessageReaction reaction = event.getReaction();
        MessageReaction.ReactionEmote emote = reaction.getReactionEmote();
        MessageChannel channel = event.getChannel();
        Member user = event.getMember();
        Guild g = event.getGuild();
        long m = event.getMessageIdLong();
        for (long[] l: MessageDB.Messages
        ) {
            if(l[0] == m)
            {
                if(l[1] == emote.getIdLong())
                {
                    Role r = g.getRoleById(l[2]);
                    g.addRoleToMember(user.getIdLong(),r).queue();
                }
            }
        }


    }
}
