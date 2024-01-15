package test;

import java.util.Observable;
import java.util.Observer;

import test.LevelA.Direction;

import java.beans.XMLDecoder;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainTrain1 {
	
	public static void q1a(){
		LevelA l=new LevelA();
		if(!Observable.class.isAssignableFrom(l.getClass()))
			System.out.println("LevelA is not Observable (-10)"); // 10
		else{

			boolean[] fail={true};
			Observer x=new Observer(){
				@Override
				public void update(Observable arg0, Object arg1) {
					fail[0]=false;
				}
			};
			Object o=l;			
			((Observable)o).addObserver(x);
			
			l.setMovePolicy((char[][] data, int cx,int cy, Direction d)->{return true;});
			if(fail[0])
				System.out.println("changing the policy does not notify observers  (-3)"); // 3
			fail[0]=true;
			l.setData(null, 0, 0);
			if(fail[0])
				System.out.println("changing the data does not notify observers  (-3)"); // 3
			fail[0]=true;
			l.moveCharacter(Direction.down);
			if(fail[0])
				System.out.println("moving the character does not notify observers (-4)"); // 4
		}
		
	}

	static String res="";
	

	
	public static void q1b(){
		
		testSerializable();
		
		Level l=new Level();
		char[][] data={{'a','b','c'}};
		l.setData(data, 5, 5);
		Random r=new Random();
		final int port=5000+r.nextInt(500);
		
		// server
		Thread t=new Thread(()->{
			try{
				ServerSocket server=new ServerSocket(port);
				server.setSoTimeout(1000);
				try{
					Socket client=server.accept();
					XMLDecoder in=new XMLDecoder(client.getInputStream());
					
					Callable<Level> c=new Callable<Level>(){
						@Override
						public Level call() throws Exception {
							return (Level)in.readObject();
						}
					};
					
					ExecutorService ex=Executors.newSingleThreadExecutor();
					Future<Level> f=ex.submit(c);
					Level l2=null;
					try {
						l2=f.get(2000,TimeUnit.MILLISECONDS);
					} catch (InterruptedException | ExecutionException | TimeoutException e) {
						System.out.println("failed to recieve Level object (-10)"); // 10
					}
//					if(l2!=null){
//						if(l2.data==null || l2.getData()[0].length!=3 || l2.getData()[0][0]!='a'  || l2.getData()[0][1]!='b' || l2.getData()[0][2]!='c'){
//							System.out.println("failed to recieve Level data for object 1b"); // 10
//						}
//						if(l2.getCx()!=5 || l2.getCy()!=5)
//							System.out.println("failed to receive correct values for cx,cy in question 1b"); // 10
//						in.close();
//					}
					client.close();
					server.close();
					ex.shutdown();
				}catch(SocketTimeoutException e){
					System.out.println("client failed to connect (-15)"); //15
				}
			}catch(IOException e){e.printStackTrace();}
		});
		t.start();
		
		try {
			MyClient.sendLevel("127.0.0.1", port, l);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	
	private static void testSerializable() {
		if(Level.class.getInterfaces().length==0 || Level.class.getInterfaces().length>1 || !Level.class.getInterfaces()[0].equals(Serializable.class)){
			System.out.println("Level is not Serializable  (-5)"); // 5
			return;
		}
		Method[] methods=Level.class.getMethods();
		HashSet<String> required=new HashSet<String>();
		required.add("getData");
		required.add("getCx");
		required.add("getCy");
		required.add("setCx");
		required.add("setCy");
		for(Method m : methods)
			required.remove(m.getName());
		if(!required.isEmpty())
			System.out.println("Level is not properly Serializable  (-5)"); // 5
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Q1 test");
		q1a();
		System.out.println("Q2 test");
		q1b();
		System.out.println("done");
	}

}
