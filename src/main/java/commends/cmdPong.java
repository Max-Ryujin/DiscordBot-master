package commends;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class cmdPong implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event)
    {

        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.blue);
        eb.setTitle("ping!","http://stewd.io/pong/");
        event.getTextChannel().sendMessage(eb.build()).queue();

        }
            @Override
            public void executed ( boolean sucess, MessageReceivedEvent event){

            }

            @Override
            public String help () {
                return null;
            }
        }