import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
public class TankClient extends Frame {
	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
	public static final String TITLE = "坦克大战v2.0";
	Tank myTank = new Tank(50, 50, true, this);
	Tank enemyTank;
	Wall wall1 = new Wall(0, 200, 300, 20);
	//Wall wall2 = new Wall()
	Image offScreenImage = null;
	Explode ex = null;
	List<Missile> missiles = new ArrayList<Missile>();
	List<Explode> explodes = new ArrayList<Explode>();
	List<Tank> tanks = new ArrayList<Tank>();
	
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
		//启动线程来进行重画操作
		new Thread(new PaintThread()).start();
		//new十辆坦克
		for(int i = 0; i<10; i++) {
			tanks.add(new Tank(50+30 * i, 250, false, this));
		}
		
	}
	
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("missiles counts:" + missiles.size(), 20, 40);
		g.drawString("explodes counts:" + explodes.size(), 20, 60);
		g.drawString("tanks counts:" + tanks.size(), 20, 80);
		g.setColor(c);
		//把子弹的集合画出来,并进行相关函数的调用.	
		for(int i = 0 ; i < missiles.size(); i++) {
				
			Missile m = this.missiles.get(i);
			m.draw(g);
			m.hitTanks(this.tanks);
			m.hitTank(myTank);
			m.hitWall(wall1);
		}
			
		//把爆炸的集合画出来,并进行相关函数的调用.
		for(int i = 0; i < explodes.size(); i++) {
			ex = this.explodes.get(i);
			ex.draw(g);
		}

		myTank.draw(g);
		wall1.draw(g);
		
		//把敌人坦克的集合画出来,并进行相关函数的调用.
		for(int i = 0; i < tanks.size(); i++) {
			enemyTank = tanks.get(i);
			enemyTank.draw(g);
			enemyTank.hitWall(wall1);
		}
		
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
	//键盘监听器
	private class KeyMonitor extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			myTank.keyReleased(e);
		}
	}
	
}
