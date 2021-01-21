package commends;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmdHelp implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event){
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event)
    {
        String autor = event.getAuthor().getName();
        String text =
                "-help \n" +
                "-ping \n" +
                "-bestenliste \n" +
                "-Level \n" +
                "-profile <Name> \n"
                 +"-mandelbrot \n"+
                "-coinflip \n" +
                "-feedback <Feedback> \n" +
                "-Go \n"+
                "-Mandelbrot \n"+
                "-Chess \n"+
                "-new \n";
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.GREEN);
        eb.setTitle("Hilfe","http://www.keineahnung.de/Home");
        eb.addField("Befehle:",text,false );
        eb.addField("Sonstiges:","Frag nach bei Ryujin wenn etwas unklar ist",false );
        event.getTextChannel().sendMessage(eb.build()).queue();

    }

    @Override
    public void executed(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
