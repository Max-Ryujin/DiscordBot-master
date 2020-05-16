package commends;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmdFeedback implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
   if(args.length>=1) {
       event.getGuild().getOwner().getUser().openPrivateChannel().queue();
       String string  = " ";
       for (String ss:args
            ) {
           string += ss;
       }
       String finalString = string;
       event.getJDA().getPrivateChannels().forEach(privateChannel -> privateChannel.sendMessage(finalString + " von " + event.getAuthor().getName()).queue());

       EmbedBuilder eb = new EmbedBuilder();
       eb.setColor(Color.blue);
       eb.addField("Feedback:","Dein Feedback wurde weiter geleitet",false );
       event.getTextChannel().sendMessage(eb.build()).queue();
   }
   else
   {
       EmbedBuilder eb = new EmbedBuilder();
       eb.setColor(Color.blue);
       eb.addField("Feedback:","Füge das Feedback hinter dem Befehl hinzu",false );
       event.getTextChannel().sendMessage(eb.build()).queue();
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
