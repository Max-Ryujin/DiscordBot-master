package commends;

import core.Leveldb;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

public class cmdProfile implements  Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(args.length<1) {
            event.getTextChannel().sendMessage(profile(event.getAuthor(), event.getGuild()).build()).queue();
        }
        else
        {
            int l = args.length;
            String username = args[0];
            for(int i = 1; i<l;i++ )
            {
                username+= " "+args[i];
            }
            if(!event.getGuild().getMembersByEffectiveName(args[0],false).isEmpty())
             {
                 User x = event.getGuild().getMembersByEffectiveName(args[0],false).get(0).getUser();
                 event.getTextChannel().sendMessage(profile(x, event.getGuild()).build()).queue();
             }
            else if(!event.getGuild().getMembersByNickname(args[0],false).isEmpty())
             {
                User x = event.getGuild().getMembersByNickname(args[0],false).get(0).getUser();
                 event.getTextChannel().sendMessage(profile(x, event.getGuild()).build()).queue();
             }
            else if(!event.getGuild().getMembersByName(args[0],false).isEmpty())
             {
                User x = event.getGuild().getMembersByName(args[0],false).get(0).getUser();
                 event.getTextChannel().sendMessage(profile(x, event.getGuild()).build()).queue();
             }
            else
               {event.getTextChannel().sendMessage("Person nicht gefunden").queue();}

        }
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }

    public EmbedBuilder profile(User x, Guild g)
    {
        long Avatarid = x.getIdLong();
        long lvl = Leveldb.getLevel(Avatarid);
        String Name = x.getName();
        String Name2 = g.getMembersByName(x.getName(),false).get(0).getNickname();
        String datum = g.getMembersByName(x.getName(),false).get(0).getTimeJoined().format(ISO_LOCAL_DATE );
        String rollen = "";
        for(Role r: g.getMember(x).getRoles())
        {
            rollen += r.getName()+"\n";

        }

        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.blue);
        eb.addField("Name:",Name,false);
        if(Name2 != null){  eb.addField("Nickname:",Name2,false);}
        eb.addField("Joindate:",datum,false);
        eb.addField("Level:", String.valueOf(lvl),false);
        eb.addField("XP:", String.valueOf(Leveldb.getXP(Avatarid)),false);
        eb.addField("ID:", String.valueOf(Avatarid),false);
        eb.addField("Rollen:", rollen,false);

        eb.setThumbnail(x.getAvatarUrl());
        return eb;
    }
}
