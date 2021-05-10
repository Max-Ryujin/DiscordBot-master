package commends;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmdNew implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {


        event.getTextChannel().sendMessage(New(event.getGuild()).build()).queue();
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }

    public static EmbedBuilder New(Guild g)
    {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.ORANGE);
        eb.setThumbnail(g.getJDA().getSelfUser().getAvatarUrl());

        eb.addField("Version 3.0.0","Big Changes, Bla bla bla . You will See.",false);
        eb.addField("Version 3.0.1","Fixed the channel vor levelup",false);
        eb.addField("Version 3.0.2","<:Offline:712680947505692704>",false);
        eb.addField("Version 3.0.3","Fixes ...",false);
        eb.addField("Version 3.1.0","Bot hat jetzt lan und die scheiß online offline nachrichten sind weg",false);
        eb.addField("Version 3.1.1","Fixed a Bug where Members who reached lvl 50 got two Roles at once.",false);
        eb.addField("Version 3.2.0","Send befehl",false);
        eb.addField("Version 3.2.1","Fixed Leaderboard and updated -help",false);
        eb.addField("Version 3.3.0","New reaction funtionality",false);
        eb.addField("Version 3.3.1","I love chess",false);
        eb.addField("Version 3.4.0","Admin Tools",false);
        eb.addField("Version 3.4.1","Improvements ",false);
        eb.addField("Version 3.4.2"," Profil command shows user with space in their names now properly",false);

       
        return eb;
    }
}
