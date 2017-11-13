import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TankServer {
	public static final int TCP_PORT = 8888;
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(TCP_PORT);
			while(true) {
				Socket s = ss.accept();
System.out.println("A Client connect! IP:" + s.getInetAddress() + ":" + s.getPort());
			}
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

}
