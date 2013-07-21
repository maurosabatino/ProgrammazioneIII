import java.io.*;
import java.net.*;
import java.util.*;

public class ServerEchoThread {
	public static void main(String[]args){
		try{
			int i= 1;
			ServerSocket s = new ServerSocket(8189);
			while(true){
				Socket incoming = s.accept();
				System.out.println("creato: "+i);
				Runnable r = new ServerThreadHandler(incoming,i);
				Thread t = new Thread(r);
				t.start();
				i++;
			}
		}catch(IOException e){e.printStackTrace();}
	}
}

class ServerThreadHandler implements Runnable{
	Socket incoming;
	int counter;
	public ServerThreadHandler(Socket i, int c){
		incoming = i;
		counter=c;
	}
	public void run(){
		try{
			try{
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				Scanner in = new Scanner(inStream);
				PrintWriter out = new PrintWriter(outStream,true);
				out.println("hello");
				boolean done=false;
				while(!done && in.hasNextLine()){
					String line=in.nextLine();
					System.out.println("Server numero:"+counter+"ripete:"+line);
					out.println("server"+line);
					if(line.trim().equals("bye"))
						done=true;
				}
			}finally {incoming.close();}
		}catch (IOException e){e.printStackTrace();}
	}
}
