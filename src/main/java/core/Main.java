package core;


import commends.*;
import listeners.*;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import utils.STATICS;

import javax.security.auth.login.LoginException;

public class Main {
    private int zähler;

    public static void main(String[] Args)
    {
        JDABuilder builder = new JDABuilder(AccountType.BOT);

        builder.setToken("MzQ2MzMyMzEzMDc4MDcxMzA3.XpbUlw.4c7aBwO80WiU56yrNQe-R6T86ig");
        builder.setAutoReconnect(true);
        builder.addEventListeners(new readyLIstener()
                ,new commandListener()
                ,new DisconnectListener()
                ,new onGuildVoiceJoinListener()
                ,new guildjoinListener()
                ,new typinglistener()
                ,new onGuildVoiceLeaveListener()
                ,new onGuildVoiceMoveListener()
                ,new reactionlistener()
                ,new ReconnectListener());

        builder.setActivity((Activity.playing("version. "+STATICS.VERSION)));
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);

        try
        {
            Leveldb leveldb = new Leveldb();
            MessageDB messageDB = new MessageDB();
        }
        catch (Exception e)
        {
            System.out.println("Dateifehler");
        }
        addCommands();

        try {
            JDA jda = builder.build();


        }
         catch(LoginException e)
        {
            e.printStackTrace();
        }

    }
   public static void addCommands()
   {

       //standard
       commandHandler.commands.put("help", new cmdHelp());
       commandHandler.commands.put("h", new cmdHelp());

       commandHandler.commands.put("new",new cmdNew());
       commandHandler.commands.put("update",new cmdNew());

       commandHandler.commands.put("profile",new cmdProfile());
       commandHandler.commands.put("profil",new cmdProfile());

       //bestenliste
       commandHandler.commands.put("scoreboard", new cmdBestenliste());
       commandHandler.commands.put("bestenliste", new cmdBestenliste());
       commandHandler.commands.put("save", new cmdSave());
       //level
       commandHandler.commands.put("level", new cmdLevel());
       commandHandler.commands.put("lvl", new cmdLevel());
       commandHandler.commands.put("setlvl", new cmdSetLvl());
       commandHandler.commands.put("setlevel", new cmdSetLvl());
       commandHandler.commands.put("all", new cmdall());
       commandHandler.commands.put("blacklist", new cmdBlacklist());

       // sonstiges
       commandHandler.commands.put("pong", new cmdPong());
       commandHandler.commands.put("ping", new cmdPing());
       commandHandler.commands.put("coinflip", new cmdCoinflip());
       commandHandler.commands.put("feedback", new cmdFeedback());
       commandHandler.commands.put("mandelbrot",new cmdMandelbrot());
       commandHandler.commands.put("test",new cmdTest());
       commandHandler.commands.put("go",new cmdGo());
       commandHandler.commands.put("getspeaker",new cmdGetSpeaker());
       commandHandler.commands.put("send",new cmdSend());
       commandHandler.commands.put("getblacklist",new cmdGetBlacklist());
       commandHandler.commands.put("reaction",new cmdReaktion());
       commandHandler.commands.put("chess",new cmdChess());
       commandHandler.commands.put("schach",new cmdChess());
       commandHandler.commands.put("turnier",new cmdChess());

   }


}
