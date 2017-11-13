import java.io.DataInputStream;
import java.net.DatagramSocket;


public class TankMoveMsg implements Msg {
	TankClient tc;
	TankMoveMsg(TankClient tc) {
		this.tc = tc;
	}
	public void send(DatagramSocket ds, String ip, int udpPort) {
		
	}

	public void parse(DataInputStream dis) {
		
	}

}
