import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class NetClient {
	
	public boolean connect(String ip, int port) {
		try {
			Socket s = new Socket(ip, port);
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
System.out.println("Connect to the Server successfully!");
		return true;
		
	}
}
