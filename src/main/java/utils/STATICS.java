package utils;

import net.dv8tion.jda.api.OnlineStatus;

import java.util.LinkedList;

public class STATICS {


    public static String TOKEN = "";

    public static long GuildId = 188893186435973121l;

    //######### GENERAL BOT SETTINGS #########//


    public static String VERSION = "3.0.0";

    public static long afkchannelid = 188893186435973122l;

    public int voiceXP = 1;

    public static String PREFIX = "-";

    public static long afkmessageid;

    public static OnlineStatus STATUS = OnlineStatus.ONLINE;

    public static LinkedList<Long> blacklist = new LinkedList<>();

    public static LinkedList<VoiceChatMember> speakingMember = new LinkedList<>();

}
