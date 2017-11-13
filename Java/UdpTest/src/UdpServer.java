import java.io.*;
import java.net.*;
public class UdpServer {
	public static final int TCP_PORT = 8888;
	public static final int UDP_PORT = 6666;
	Socket s = null;
	DataInputStream dis =null;
	DatagramSocket ds = null;
	DatagramPacket dp = null;
	int clientUdpPort;
	String clientIP;
	public static void main(String[] args) {
		new UdpServer().start();
	}
	private void start() {
		new Thread(new UdpReciveThread()).start();	
		try {
			ServerSocket ss = new ServerSocket(8888);
			while(true) {
				s = ss.accept();
				System.out.println("connect!");
				DataInputStream dis = new DataInputStream(s.getInputStream());
				clientUdpPort = dis.readInt();
				clientIP = s.getInetAddress().getHostAddress();
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				dis.close();
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	private class UdpReciveThread implements Runnable {
		byte[] buf = new byte[1024];
		public void run() {
			try {
				ds = new DatagramSocket(UDP_PORT);
			} catch (SocketException e) {
				e.printStackTrace();
			}
System.out.println("A UDPThread start,port is:" + UDP_PORT);
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			try {
				ds.receive(dp);
System.out.println("A UdpClient connected");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		
	}
}
