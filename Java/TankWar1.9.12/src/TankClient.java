import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
public class TankClient extends Frame {
	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
	public static final String TITLE = "坦克大战v1.9.12";
	Tank myTank = new Tank(50, 50, true, this);
	Tank enemyTank;
	Image offScreenImage = null;
	Explode ex = null;
	NetClient nc = new NetClient(this);
	List<Missile> missiles = new ArrayList<Missile>();
	List<Explode> explodes = new ArrayList<Explode>();
	List<Tank> tanks = new ArrayList<Tank>();
	ConnDialog dialog = new ConnDialog();
	public void launchframe() {
		
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setLocation(300, 100);
		this.setBackground(Color.BLACK);
		this.setTitle(TITLE);
		this.setResizable(false);
		this.setVisible(true);
		//注册键盘监听.
		this.addKeyListener(new KeyMonitor());
		//注册窗口监听.
		this.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		
		});
	
		new Thread(new PaintThread()).start();
		/*
		for(int i = 0; i<10; i++) {
			
			tanks.add(new Tank(50+30 * i, 250, false, this));
			
		}
		*/
		nc = new NetClient(this);
		
	}
	public void paint(Graphics g) {
		
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("missiles counts:" + missiles.size(), 20, 40);
		g.drawString("explodes counts:" + explodes.size(), 20, 60);
		g.drawString("tanks counts:" + tanks.size(), 20, 80);
		g.setColor(c);
			
		for(int i = 0 ; i < missiles.size(); i++) {
			Missile m = this.missiles.get(i);
			m.draw(g);
			//m.hitTanks(this.tanks);
			m.hitTank(myTank);
		}
			
		
		for(int i = 0; i < explodes.size(); i++) {
				
			ex = this.explodes.get(i);
			ex.draw(g);
				
		}
		
		myTank.draw(g);
		for(int i = 0; i < tanks.size(); i++) {
				
			enemyTank = tanks.get(i);
			enemyTank.draw(g);
				
		}
		//enemyTank.draw(g);
		
		
	}
	//屏幕双缓冲(不重要)
	public void update(Graphics g) {
		if(offScreenImage == null) {
			
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
			
		}
		
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
		
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TankClient tc = new TankClient();
		tc.launchframe();
	}
	
	public class PaintThread implements Runnable {
		
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	private class KeyMonitor extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_C) {
				dialog.setVisible(true);
			}
			myTank.keyPressed(e);
		}
		
		public void keyReleased(KeyEvent e) {
			myTank.keyReleased(e);
		}
		
	}
	
	class ConnDialog extends Dialog{
		TextField ipTf = new TextField("127.0.0.1", 12);
		TextField tcpPortTf = new TextField("" + TankServer.TCP_PORT, 4);
		TextField myUDPPort = new TextField("2223", 4);
		Button b = new Button("提交");
		public ConnDialog() {
			super(TankClient.this, "连接参数设置", true);
			this.setLayout(new FlowLayout());
			this.add(new Label("IP:"));
			this.add(ipTf);
			this.add(new Label("TCP_Port:"));
			this.add(tcpPortTf);
			this.add(new Label("My UDPPort:"));
			this.add(myUDPPort);
			this.add(b);
			this.setLocation(300, 300);
			this.pack();
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			b.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					
					String ip = ipTf.getText().trim();
					int tcpPort = Integer.parseInt(tcpPortTf.getText().trim());
					int udpPort = Integer.parseInt(myUDPPort.getText().trim());
					nc.setUdpPort(udpPort);
					nc.connect(ip, tcpPort);
					
					setVisible(false);
				}
				
			});
		}
	}
	
}
