import java.io.*;
import java.net.*;
import java.util.*;


public class SocketTest {
	public static void main(String[] args){
		try{
			Socket s = new Socket("androidworld.it",80);
			try{
				InputStream inStream = s.getInputStream();
				Scanner in = new Scanner(inStream);
				while(in.hasNextLine()){
					String line = in.nextLine();
					System.out.println(line);
				}
			}
			finally{
				s.close();
			}
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
