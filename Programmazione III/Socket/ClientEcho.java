import java.io.*;
import java.net.*;
import java.util.*;

public class ClientEcho {
	public static void main(String[]args){
		try{
			String nomeLocale = InetAddress.getLocalHost().getHostName();
			System.out.println("io sono: "+nomeLocale);
			Socket s = new Socket(nomeLocale,8189);
			try{
				InputStream inStream = s.getInputStream();
				OutputStream outStream = s.getOutputStream();
				Scanner in = new Scanner(inStream);
				PrintWriter out = new PrintWriter(outStream,true);
				Scanner stin = new Scanner(System.in);
				String line = in.nextLine();
				System.out.println(line);
				boolean done=false;
				while(!done){
					String lineOut = stin.nextLine();
					out.println(lineOut);
					if(lineOut.equals("bye"))
						done=true;
				}
			}finally {s.close();}
		}catch (IOException e){e.printStackTrace();}
	}
}
