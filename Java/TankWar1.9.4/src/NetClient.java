import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;


public class NetClient {
	public static int UDP_PORT_START = 2333;
	TankClient tc ;
	Socket s = null;
	DatagramSocket ds = null;
	private int udpPort;
	NetClient(TankClient tc) {
		udpPort = UDP_PORT_START ++;
		this.tc = tc;
		try {
			ds = new DatagramSocket(udpPort);
		} catch (SocketException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	public boolean connect(String ip, int port) {
		try {
			s = new Socket(ip, port);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeInt(udpPort);
			DataInputStream dis = new DataInputStream(s.getInputStream());
			tc.myTank.id = dis.readInt();
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				s.close();
				s = null;
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
System.out.println("Connect to the Server successfully!");
		TankNewMsg msg = new TankNewMsg(tc.myTank);
		send(msg);
		new Thread(new UDPRecvThread()).start();
		return true;
		
	}
	
	
	
	public void send(TankNewMsg msg) {
		msg.send(ds, "127.0.0.1", TankServer.UDP_PORT);
	}
	
	private class UDPRecvThread implements Runnable {
		byte[] buf = new byte[1024];
		public void run() {
			
			while(ds != null) {
				DatagramPacket dp = new DatagramPacket(buf, 0, buf.length);
				try {
					ds.receive(dp);
System.out.println("A Packet is received from the Server!");
					parse(dp);
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				
			}
		}
		private void parse(DatagramPacket dp) {
			ByteArrayInputStream bais = new ByteArrayInputStream(buf, 0, buf.length);
			DataInputStream dis = new DataInputStream(bais);
			TankNewMsg msg = new TankNewMsg(NetClient.this.tc);
			msg.parse(dis);
			
		}
		
	}
}