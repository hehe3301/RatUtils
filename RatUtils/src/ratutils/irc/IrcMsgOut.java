package ratutils.irc;

/**
 * Created by hehe3 on 8/24/2017.
 */
public class IrcMsgOut {
    private String channel;
    private String message;

    public IrcMsgOut(String channel, String message) {
        this.channel = channel;
        this.message = message;
    }

    @Override
    public String toString() {
        return "IrcMsgOut{" +
                "channel='" + channel + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
