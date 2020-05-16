package utils;

public class VoiceChatMember {

    private long id;
    private long startTime;

    public VoiceChatMember(long id)
    {
        this.startTime = System.currentTimeMillis();
        this.id = id;
    }

    /**
     * @return Milliseconds since join
     */
    public long getspeakingTime()
    {
        return System.currentTimeMillis() - startTime;
    }

    public long Getid()
    {
        return id;
    }



}
