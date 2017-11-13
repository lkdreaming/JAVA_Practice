import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;


public class TankNewMsg implements Msg {
	Tank tank;
	TankClient tc;
	public TankNewMsg(Tank tank) {
		this.tank = tank;
	}
	
	

	public TankNewMsg(TankClient tc) {
		this.tc = tc;
	}

/*
 * �������ݣ��� Javadoc��
 * @see Msg#send(java.net.DatagramSocket, java.lang.String, int)
 */

	public void send(DatagramSocket ds, String ip, int udpPort) {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		try {
			dos.writeInt(tank.id);
			dos.writeInt(tank.x);
			dos.writeInt(tank.y);
			dos.writeInt(tank.dir.ordinal());
			dos.writeBoolean(tank.good);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] buf = baos.toByteArray();
		
		try {
			DatagramPacket dp = new DatagramPacket(buf,buf.length, new InetSocketAddress(ip, udpPort));
			ds.send(dp);
		}  catch (SocketException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}


/*
 * ������������ݣ��� Javadoc��
 * @see Msg#parse(java.io.DataInputStream)
 */
	public void parse(DataInputStream dis) {
		try {
			int id = dis.readInt();
			int x = dis.readInt();
			int y = dis.readInt();
			Dir dir = Dir.values()[dis.readInt()];
			boolean good = dis.readBoolean();
			if(tc.myTank.id == id) {
				return;
			}
			Tank t = new Tank(x,y,good,tc);
			t.id = id;
			tc.tanks.add(t);
//System.out.println("id:" + id + ", x:" + x + ", y:" + ", dir:" + ", good:" + good); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}