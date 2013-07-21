import java.io.*;
import java.net.*;

public class URLReader {
	public static void main(String[]args) throws Exception{
		URL androidWorld = new URL("http://yahoo.com/");
		BufferedReader in = new BufferedReader(
				new InputStreamReader(androidWorld.openStream()));
		PrintWriter out = new PrintWriter(
				new FileWriter("androidworld.html"));
		String inputLine;
		while((inputLine=in.readLine())!=null )
			out.println(inputLine);
			in.close();
			out.close();
	}
}
