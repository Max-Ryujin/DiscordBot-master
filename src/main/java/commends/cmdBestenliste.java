package commends;

import core.Leveldb;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmdBestenliste implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(args.length == 0) {
            event.getTextChannel().sendMessage(Bestenliste(event.getGuild(),false).build()).queue();
        }
        else
        {
            event.getTextChannel().sendMessage(Bestenliste(event.getGuild(),true).build()).queue();
        }
    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }

    public static EmbedBuilder Bestenliste(Guild g,boolean full) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("BestenListe:").setColor(Color.blue);

        Leveldb.Sortieren();

        int counter = 16;


        String output = "\uD83D\uDC51";


        int platz = 1;

        for (int i = 0; i < 11; i++) {
            long userid = Leveldb.members.get(i)[0];
            Member user;
            try {
                user = g.retrieveMemberById(userid).complete();
            } catch (Exception e) {
                System.out.println(userid);
                continue;
            }
            if (user == null || user.getIdLong() == 346332313078071307l) {
                System.out.println("user does not exists");
            } else {
                output += platz + ".   " + g.getMemberById(userid).getEffectiveName() + "  Level:  " + Leveldb.members.get(i)[2] + "  und " + Leveldb.members.get(i)[1] + " XP \n  ";

                platz++;
            }

        }

        eb.addField("", output, true).setColor(Color.orange);

        return eb;


    }


}
