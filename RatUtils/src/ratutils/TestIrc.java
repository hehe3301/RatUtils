package ratutils;

import ratutils.irc.IrcConnection;

import java.io.*;
import java.net.*;

public class TestIrc {

    public static void main(String[] args)
	{
        try {
			IrcConnection connection = new IrcConnection("irc.fuelrats.com", "Belmurtoc[BETA_CLIENT]", "Belmurtoc", "Belmurtoc[PC]");
		} catch(Exception e) {
        	e.printStackTrace();
		}

	}
}