import java.io.*;
import java.net.*;
public class UdpClient {
	public static final String IP = "127.0.0.1";
	public static final int TCP_PORT = 8888;
	public static final int UDP_PORT = 3337;
	Socket s = null;
	public static void main(String[] args) {
		new UdpClient().connect(IP,TCP_PORT);
	}
	private void connect(String ip, int tcp_port) {
		try {
			s = new Socket(ip, tcp_port);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeInt(UDP_PORT);
		} catch (UnknownHostException e) {
			e.printStackTrace();		
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			DataOutputStream dos = new DataOutputStream(baos);
			byte[] buf = baos.toByteArray();
			DatagramSocket ds = new DatagramSocket(UDP_PORT);
			DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress(ip, UdpServer.UDP_PORT));
			ds.send(dp);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
