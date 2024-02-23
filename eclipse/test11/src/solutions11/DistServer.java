//package solutions11;
//
//import java.awt.Point;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;
//import java.util.function.Function;
//
//public class DistServer {
//
//	public static void start(int port, Function<String, String> f) {
//		try {
//			ServerSocket server = new ServerSocket(port);
//			Socket client = server.accept();
//			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
//			PrintWriter out = new PrintWriter(client.getOutputStream());
//
//			String line;
//			while (!(line = in.readLine()).equals("bye")) {
//				out.println(f.apply(line));
//				out.flush();
//			}
//
//			in.close();
//			out.close();
//			client.close();
//			server.close();
//		} catch (IOException e) {
//		}
//
//	}
//
//	public static void start(int port) {
//		start(port, (line) -> {
//			EuclideanDist ed = new EuclideanDist();
//			Scanner s = new Scanner(line);
//			Point p1 = new Point(s.nextDouble(), s.nextDouble(), s.nextDouble());
//			Point p2 = new Point(s.nextDouble(), s.nextDouble(), s.nextDouble());
//			s.close();
//			double dist = ed.distance(p1, p2);
//			dist = ((int) (dist * 1000)) / 1000.0;
//			return "" + dist;
//		});
//	}
//
//}
