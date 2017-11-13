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
	//public static int UDP_PORT_START = 2334;
	TankClient tc ;
	Socket s = null;
	DatagramSocket ds = null;
	private int udpPort;
	public int getUdpPort() {
		return udpPort;
	}
	public void setUdpPort(int udpPort) {
		this.udpPort = udpPort;
	}
	NetClient(TankClient tc) {
		//udpPort = UDP_PORT_START ++;
		this.tc = tc;
	}
	public boolean connect(String ip, int port) {
		try {
			ds = new DatagramSocket(udpPort);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		try {
			s = new Socket(ip, port);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeInt(udpPort);
			DataInputStream dis = new DataInputStream(s.getInputStream());
			//只加了主战坦克
			tc.myTank.id = dis.readInt();
			if(tc.myTank.id%2 == 0)	tc.myTank.good = false;
			else tc.myTank.good = true;
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
				e.printStackTrace();
			}
		}
System.out.println("Connect to the Server successfully!");
//添加了主站坦克
		TankNewMsg msg = new TankNewMsg(tc.myTank);
		send(msg);
		new Thread(new UDPRecvThread()).start();
		return true;
		
	}
	
	
	
	public void send(Msg msg) {
		msg.send(ds, "127.0.0.1", TankServer.UDP_PORT);
	}
	
	private class UDPRecvThread implements Runnable {
		byte[] buf = new byte[1024];
		public void run() {
			
			while(ds != null) {
				DatagramPacket dp = new DatagramPacket(buf, 0, buf.length);
				try {
					ds.receive(dp);
//System.out.println("A Packet is received from the Server!");
					parse(dp);
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
		}
		private void parse(DatagramPacket dp) {
			ByteArrayInputStream bais = new ByteArrayInputStream(buf, 0, dp.getLength());
			DataInputStream dis = new DataInputStream(bais);
			int msgType = 0;
			Msg msg = null;
			try {
				msgType = dis.readInt();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch(msgType) {
			case Msg.TANK_NEW_MSG:
				msg = new TankNewMsg(NetClient.this.tc);
				msg.parse(dis);
				break;
			case Msg.TANK_MOVE_MSG:
				msg = new TankMoveMsg(NetClient.this.tc);
				msg.parse(dis);
				break;
			case Msg.MISSILE_NEW_MSG:
				msg = new MissileNewMsg(NetClient.this.tc);
				msg.parse(dis);
				break;
			case Msg.TANK_DEAD_MSG:
				msg = new TankDeadMsg(NetClient.this.tc);
				msg.parse(dis);
				break;
			}
			
			
		}
		
	}
}
