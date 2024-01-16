package test;

import java.beans.XMLEncoder;
import java.io.IOException;
import java.net.Socket;

public class MyClient {
	
	public static void sendLevel(String ip,int port,Level level) throws IOException{
		// write your answer here
		Socket server=new Socket(ip,port);
		XMLEncoder out=new XMLEncoder(server.getOutputStream());
		out.writeObject(level);
		out.close();
		server.close();
	}

}
