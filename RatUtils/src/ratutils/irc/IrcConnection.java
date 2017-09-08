package ratutils.irc;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Queue;

/**
 * Created by hehe3 on 8/24/2017.
 */
public class IrcConnection {
    private String server;// = "irc.fuelrats.com"; //Server to connect to
    private String nick;// = "Belmurtoc[BETA_CLIENT]"; //Nickname that will be used on the server
    private String login;// = "Belmurtoc";
    private String boss;// = "Belmurtoc[PC]";
    private List<String> channel_list;// = "#fuelrats"; // The channel which the bot will join.
    private Queue<IrcMsgIn> in_msg_queue;
    private Queue<IrcMsgOut> out_Msg_queue;

    Socket socket;// = new Socket(server, 6667);
    BufferedWriter writer;// = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream( )));
    BufferedReader reader;// = new BufferedReader(new InputStreamReader(socket.getInputStream( )));
    Thread server_connection;

    public IrcConnection(String server, String nick, String login, String boss) throws IOException{
        this.server = server; // irc.fuelrats.com
        this.nick = nick; // Belmurtoc[BETA_CLIENT]
        this.login = login; // "Belmurtoc"
        this.boss = boss; // Belmurtoc[PC]

        server_connection = new Thread(new IrcListener(this));
        server_connection.start();

    }

    public void writeToIrc(IrcMsgOut msg) {
        try {
            writer.write("PRIVMSG " + msg.getChannel() + " :" + msg.getMessage() + "\r\n");
            writer.flush();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public String getServer() {
        return server;
    }

    public String getNick() {
        return nick;
    }

    public String getLogin() {
        return login;
    }

    public String getBoss() {
        return boss;
    }
}

class IrcListener implements Runnable {

    Thread runner;
    IrcConnection owner;
    public IrcListener() {
    }
    public IrcListener(IrcConnection owner) {
        runner = new Thread(this, "IrcListener"); // (1) Create a new thread.
        this.owner=owner;
        runner.start(); // (2) Start the thread.
    }
    public void run() {
        //Display info about this particular thread
        System.out.println(Thread.currentThread());
        try {
            owner.socket = new Socket(owner.getServer(), 6667);
            owner.writer = new BufferedWriter(new OutputStreamWriter(owner.socket.getOutputStream()));
            owner.reader = new BufferedReader(new InputStreamReader(owner.socket.getInputStream()));
            // Log on to the server.
            owner.writer.write("NICK " + owner.getNick() + "\r\n");
            owner.writer.write("USER " + owner.getLogin() + " 8 * : Belmurtoc's Awesome IRC Client\r\n");
            owner.writer.flush();
            owner.writer.write("PRIVMSG " + owner.getBoss() + " :I am alive\r\n");
            // Read lines from the server until it tells us we have connected.
            String line = null;
            while ((line = owner.reader.readLine( )) != null) {
                System.out.println(line);
                if (line.indexOf("004") >= 0) {
                    // We are now logged in.
                    break;
                }
                else if (line.indexOf("433") >= 0) {
                    System.out.println("Nickname is already in use.");
                    return;
                }
                else if (line.contains("PING ")) {
                    // We must respond to PINGs to avoid being disconnected.
                    owner.writer.write("PONG " + line.substring(5) + "\r\n");
                    owner.writer.flush( );
                    break;
                }
            }//END while

            owner.writer.write("PRIVMSG " + owner.getBoss() + " :I'm here!\r\n");
            owner.writer.flush( );

            // Keep reading lines from the server.
            while ((line = owner.reader.readLine( )) != null)
            {
                if (line.contains("PING "))
                {
                    // We must respond to PINGs to avoid being disconnected.
                    owner.writer.write("PONG " + line.substring(5) + "\r\n");
                    owner.writer.flush( );
                }
                //:Belmurtoc[PC]!uid43090@belmurtoc.recruit.fuelrats.com PRIVMSG Belmurtoc[BOT] :QUIT
                else if (line.contains(owner.getBoss()) && line.contains("PRIVMSG "+owner.getNick()+" :!QUIT!" )) {
                    owner.writer.write("QUIT\r\n");
                    owner.writer.flush( );
                } else  {
                    // Print the raw line received by the bot.
                    System.out.println(line);
                }
            }
            System.out.println("ALL DONE!");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
