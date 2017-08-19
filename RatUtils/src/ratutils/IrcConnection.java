package ratutils;

import java.io.*;
import java.net.*;

public class IrcConnection {

    public static void main(String[] args) throws Exception {

        // The server to connect to and our details.
        String server = "irc.esper.net"; //Server to connect to
        String nick = "Belmurtoc[BETA_CLIENT]"; //Nickname that will be used on the server
        String login = "Belmurtoc";
        String boss = "Belmurtoc[PC]";

        // The channel which the bot will join.
        String channel = "#murtoc_bot_testing";
        
        // Connect directly to the IRC server.
        Socket socket = new Socket(server, 6667);
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream( )));
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream( )));
        
        // Log on to the server.
        writer.write("NICK " + nick + "\r\n");
        writer.write("USER " + login + " 8 * : Belmurtoc's Awesome IRC Client\r\n");
        writer.flush( );
        
        // Read lines from the server until it tells us we have connected.
        String line = null;
        while ((line = reader.readLine( )) != null) {
            
            System.out.println("STUCK HERE:??:??: "+line);
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
                System.out.println("HEY MASTER I GOT A PING");
                writer.write("PONG " + line.substring(5) + "\r\n");
                writer.flush( );
                break;
            }
            
        }
        
        // Join the channel.
        writer.write("JOIN " + channel + "\r\n");
        writer.flush( );
        
        writer.write("PRIVMSG #" + boss + ":I'm here!\r\n");
        writer.flush( );
        
        
        // Keep reading lines from the server.
        while ((line = reader.readLine( )) != null) {
            if (line.contains("PING ")) {
                // We must respond to PINGs to avoid being disconnected.
                System.out.println("HEY MASTER I GOT A PING");
                writer.write("PONG " + line.substring(5) + "\r\n");
                writer.write("PRIVMSG " + channel + " :I got pinged!\r\n");
                writer.flush( );
            }
            //:Belmurtoc[PC]!uid43090@belmurtoc.recruit.fuelrats.com PRIVMSG Belmurtoc[BOT] :QUIT
            else if (line.contains(boss) && line.contains("PRIVMSG "+nick+" :QUIT" ))
            {
                writer.write("QUIT\r\n");
                writer.flush( );
            }
            else {
                // Print the raw line received by the bot.
                System.out.println("Server sent: " + line);
            }
        }
    }

}