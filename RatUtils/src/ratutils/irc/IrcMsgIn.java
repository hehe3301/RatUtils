package ratutils.irc;


public class IrcMsgIn {
    private String time;
    private String user;
    private String channel;
    private String message;

    public IrcMsgIn(String time, String user, String channel, String message) {
        this.time=time;
        this.user=user;
        this.channel=channel;
        this.message=message;
    }

    public String getTime() {
        return time;
    }

    public String getUser() {
        return user;
    }

    public String getChannel() {
        return channel;
    }

    public String getMessage() {
        return message;
    }
}
