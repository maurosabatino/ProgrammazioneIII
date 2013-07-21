import java.io.*;
import java.net.*;
import java.util.*;


public class ServerEcho {
	public static void main(String[]args){
		try{
			ServerSocket s = new ServerSocket(8189);
			Socket incoming = s.accept();
				try{
					InputStream inStream = incoming.getInputStream();
					OutputStream outStream = incoming.getOutputStream();
					Scanner in = new Scanner(inStream);
					PrintWriter out = new PrintWriter(outStream,true);
					out.println("hello");
					boolean done=false;
					while(!done && in.hasNextLine()){
						String line=in.nextLine();
						System.out.println("Server:"+line);
						out.println("server"+line);
						if(line.trim().equals("bye"))
							done=true;
					}
				}finally{incoming.close();}
		}catch(IOException e){e.printStackTrace();}
	}
}
