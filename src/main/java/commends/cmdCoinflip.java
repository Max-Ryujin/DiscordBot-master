package commends;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;


public class cmdCoinflip implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event)
    {


          double r = Math.random();
          if (r > 0.8)
          {
              EmbedBuilder eb = new EmbedBuilder();
              eb.setColor(Color.blue);
              eb.addField("Münze:","Ups mir ist die Münze leider runtergefallen",false );
              event.getTextChannel().sendMessage(eb.build()).queue();
          } else if(r>0.40)
          {
              EmbedBuilder eb = new EmbedBuilder();
              eb.setColor(Color.blue);
              eb.addField("Münze:","Kopf",false );
              event.getTextChannel().sendMessage(eb.build()).queue();
          }
          else
              {
                  EmbedBuilder eb = new EmbedBuilder();
                  eb.setColor(Color.blue);
                  eb.addField("Münze:","Zahl",false );
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
