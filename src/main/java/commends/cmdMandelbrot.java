package commends;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.io.File;
import java.util.Random;

public class cmdMandelbrot implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.blue);
        eb.setDescription("Die Mandelbrot-Menge, benannt nach Benoît Mandelbrot, ist die Menge der komplexen Zahlen die für die rekursive Gleichung Z(n+1) = z(n)^2+c (z,c aus den komplexen zahlen) konvergiert");
        eb.setTitle("Mandelbrot","https://rwthaachende-my.sharepoint.com/:f:/g/personal/maximilian_kannen_rwth-aachen_de/ElzaUb1-u6NBq4YuPHdA0zYBdvVPYcSkUDA119aMFKDF0A?e=KTIkQ8");
        event.getTextChannel().sendMessage(eb.build()).queue();
        Random r = new Random();
        if(r.nextBoolean()) {
            File file = new File("m_rot.png");
            event.getChannel().sendFile(file, "m_rot.png").queue();
        }
        else
        {
            File file = new File("m_blau.png");
            event.getChannel().sendFile(file, "m_blau.png").queue();
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
