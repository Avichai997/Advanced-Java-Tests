package test;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Random;

public class MainTrain2 {
	
	public static void runClient1() {
		Random r=new Random();
		int port=6000+r.nextInt(1000);
		new Thread(()->DistServer.start(port,s->new StringBuffer(s).reverse().toString())).start();
		
		try {
			Socket theServer=new Socket("127.0.0.1", port);
			theServer.setSoTimeout(500);
			BufferedReader in=new BufferedReader(new InputStreamReader(theServer.getInputStream()));
			PrintWriter out=new PrintWriter(theServer.getOutputStream());
			for(int i=0;i<5;i++) {
				String str=""+r.nextInt(10000);
				out.println(str);
				out.flush();
				try {
					String ans=in.readLine();
					if(!ans.equals(new StringBuilder(str).reverse().toString()))
						System.out.println("wrong server answer (-5)");
				}
				catch(SocketTimeoutException e) {
					System.out.println("did not get an answer from your server (-5)");					
				}
			}
			out.println("bye");
			out.close();
			in.close();
			theServer.close();
		} catch (UnknownHostException e) {
			System.out.println("could not open server (-25)");
		} catch (IOException e) {
			System.out.println("could not open server due to IOException (-25)");
		}
		
	}
	
	public static double distance(Point p1, Point p2) {
		double X=(p1.getX() - p2.getX())*(p1.getX() - p2.getX());
		double Y=(p1.getY() - p2.getY())*(p1.getY() - p2.getY());
		double Z=(p1.getZ() - p2.getZ())*(p1.getZ() - p2.getZ());
		return Math.sqrt(X+Y+Z);
	}	

	
	public static void runClient2() {
		Random r=new Random();
		int port=6000+r.nextInt(1000);
		new Thread(()->DistServer.start(port)).start();
		
		try {
			Socket theServer=new Socket("127.0.0.1", port);
			theServer.setSoTimeout(500);
			BufferedReader in=new BufferedReader(new InputStreamReader(theServer.getInputStream()));
			PrintWriter out=new PrintWriter(theServer.getOutputStream());
			for(int i=0;i<5;i++) {
				Point p1=new Point(r.nextInt(100), r.nextInt(100), r.nextInt(100));
				Point p2=new Point(r.nextInt(100), r.nextInt(100), r.nextInt(100));
				out.print(p1.getX()+" "+p1.getY()+" "+p1.getZ()+" ");
				out.println(p2.getX()+" "+p2.getY()+" "+p2.getZ());
				out.flush();
				try {
					double ans=Double.parseDouble(in.readLine());
					double rans=distance(p1,p2);
					if(ans<(int)rans || ans>(int)(rans+1))
						System.out.println("wrong answer returned (-5)");
				}catch(NumberFormatException e) {
					System.out.println("worng format of answer. expecting double (-5)");
				}
				catch(SocketTimeoutException e) {
					System.out.println("did not get an answer from your server (-5)");					
				}
			}
			out.println("bye");
			out.close();
			in.close();
			theServer.close();
		} catch (UnknownHostException e) {
			System.out.println("could not open server (-25)");
		} catch (IOException e) {
			System.out.println("could not open server due to IOException (-25)");
		}
		
	}
	
	public static void main(String[] args) {
		runClient1();
		runClient2();
		System.out.println("done");
	}

}
