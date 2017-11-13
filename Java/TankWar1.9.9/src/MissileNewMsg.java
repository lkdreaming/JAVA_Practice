import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


public class MissileNewMsg implements Msg {
	int msgType = Msg.MISSILE_NEW_MSG;
	Missile m;
	TankClient tc;
	
	MissileNewMsg(Missile m){
		this.m = m;
		
	}
	
	MissileNewMsg(TankClient tc) {
		this.tc = tc;
	}
	
	public void send(DatagramSocket ds, String ip, int udpPort) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		try {
			dos.writeInt(msgType);
			dos.writeInt(m.tankId);
			dos.writeInt(m.x);
			dos.writeInt(m.y);
			dos.writeBoolean(m.good);
			dos.writeInt(m.dir.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] buf = baos.toByteArray();
		
		try {
			DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress(ip, udpPort));
			ds.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void parse(DataInputStream dis) {
		
		try {
			
			int tankId = dis.readInt();
			if(tankId == tc.myTank.id) {
				return;
			}
			int x = dis.readInt();
			int y = dis.readInt();
			boolean good = dis.readBoolean();
			Dir dir = Dir.values()[dis.readInt()];
			Missile m = new Missile(tankId, x, y, good, dir, tc);
			tc.missiles.add(m);	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
