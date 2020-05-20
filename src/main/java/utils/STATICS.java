package utils;

import net.dv8tion.jda.api.OnlineStatus;

import java.util.LinkedList;

public class STATICS {


    public static String TOKEN = "";

    public static long GuildId = 188893186435973121l;

    //######### GENERAL BOT SETTINGS #########//


    public static String VERSION = "2.7.1";

    public static long afkchannelid = 188893186435973122l;

    public int voiceXP = 1;

    public static String PREFIX = "-";

    public long afkmessageid;

    public static OnlineStatus STATUS = OnlineStatus.ONLINE;

    public static LinkedList<VoiceChatMember> speakingMember = new LinkedList<>();

}
