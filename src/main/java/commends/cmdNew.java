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
        eb.setColor(Color.MAGENTA);
        eb.setThumbnail(g.getJDA().getSelfUser().getAvatarUrl());
        eb.setTitle(":bangbang: UPDATES :bangbang:","http://www.ulistein.de/cartoons.html");
        eb.addField("Version 1.0.0","Final First Run",false);
        eb.addField("Version 1.1.0","Role adjustments and AFK channel no longer gives XP",false);
        eb.addField("Version 1.2.0","Fixed a bug where users couldent get xp if he dident wrote a message",false);
        eb.addField("Version 1.3.0","Added new Command to change lvls",false);
        eb.addField("Version 1.4.0","User without profile pictures can now get xp from speaking and CodeGeass is no longer part of the ranking",false);
        eb.addField("Version 1.5.0","Fixed a bug where xp stays over 1000 if you get more then 1000 xp at once",false);
        eb.addField("Version 1.5.1","setlvl now works with names with spaces and some code cleanup",false);
        eb.addField("Version 1.5.2","Fixed the Fix for setlevel",false);
        eb.addField("Version 1.5.3","profile works now with names with spaces",false);
        eb.addField("Version 1.5.4","Added Command mandelbrot try it if you like Mathematics ,or if you are normal, want a new wallpaper ",false);
        eb.addField("Version 1.6.0","Scoreboard works again and has a fixed length",false);
        eb.addField("Version 2.0.0","Big Changes to Code Structure. Should solve some Bugs",false);
        eb.addField("Version 2.1.0","Fixed Some Log Messages, LevelUp Messages are Back and some other smaller changes",false);
        eb.addField("Version 2.1.1","Ja ich war zu dumm Milisekunden und sekunden umzurechnen",false);
        eb.addField("Version 2.2.0","-Profil and some other commands got changes,\n More Logs for Bot disconnect to track down Bugs and other XP problems and some small improvements",false);
        eb.addField("Version 2.2.1","Added command -getspeaker(for testing)",false);
        eb.addField("Version 2.3.0","Fixed a Bug that prevented some earlier Bug fixes from working",false);
        eb.addField("Version 2.3.1","The Fix for the earlier fix was wrong so I fixed the fix for the fix. Ähm, Jup, Maybe this time ",false);
        eb.addField("Version 2.4.0","Fixed a bug where member who moved from afk channel to another channel did not get xp",false);
        eb.addField("Version 2.4.1","Added -go befehl and -getspeaker now automaticly saves level. P.S sorry for the missing weekend",false);
        eb.addField("Version 2.4.2","Lowered Xp gain from speaking",false);
        eb.addField("Version 2.5.0","All Members should be cached now on the server which makes it possible to track all user on the Server. Lets hope our Pi has enough Ram ",false);
        eb.addField("Version 2.6.0","Some Improvements and new Leaderboard channel",false);
        eb.addField("Version 2.6.1","changed Leaderboard",false);
        eb.addField("Version 2.7.0","changed Leaderboard again",false);
        return eb;
    }
}
