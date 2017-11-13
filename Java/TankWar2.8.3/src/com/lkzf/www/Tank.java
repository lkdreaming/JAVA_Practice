package com.lkzf.www;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Tank {
	private int x, y, oldX, oldY;
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	public static final int XSPEED = 5;
	public static final int YSPEED = 5;
	private boolean bL=false, bU=false, bR=false, bD = false;

	
	private boolean live = true;
	private static Random r = new Random();
	private int step = r.nextInt(12);
	private int hp = 100;
	private Direction ptDir = Direction.D;
	private Direction dir = Direction.STOP;
	TankClient tc = null;
	private boolean good;
	private BloodBar bb = new BloodBar();
	private static Toolkit tk = null;
	private static Image[] tankImages = null;
	private static Map<String, Image> imgs = new HashMap<String, Image>();
	static {
		tk = Toolkit.getDefaultToolkit();
		tankImages = new Image[] {
				tk.getImage(Tank.class.getClassLoader().getResource("images/tankU.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("images/tankD.gif")),	
				tk.getImage(Tank.class.getClassLoader().getResource("images/tankL.gif")),	
				tk.getImage(Tank.class.getClassLoader().getResource("images/tankR.gif")),	
				tk.getImage(Tank.class.getClassLoader().getResource("images/tankUL.gif")),	
				tk.getImage(Tank.class.getClassLoader().getResource("images/tankDL.gif")),	
				tk.getImage(Tank.class.getClassLoader().getResource("images/tankUR.gif")),	
				tk.getImage(Tank.class.getClassLoader().getResource("images/tankDR.gif")),	

		};
		
		imgs.put("U", tankImages[0]);
		imgs.put("D", tankImages[1]);
		imgs.put("L", tankImages[2]);
		imgs.put("R", tankImages[3]);
		imgs.put("UL", tankImages[4]);
		imgs.put("DL", tankImages[5]);
		imgs.put("UR", tankImages[6]);
		imgs.put("DR", tankImages[7]);
		
	}
	public boolean isGood() {
		return good;
	}
	public int getLife() {
		return hp;
	}
	public void setHp(int life) {
		this.hp = life;
	}
	public boolean getHp() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	
	Tank(int x, int y, boolean good, TankClient tc) {
		this.x = x;
		this.y = y;
		this.oldX = x;
		this.oldY = y;
		this.good = good;
		this.tc = tc;
	}
	
	
	
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		//画出圆来表示坦克,直线表示炮筒.
		if(live) {
//			if(good)	g.setColor(Color.RED);
//			else	g.setColor(Color.BLUE);
//			g.fillOval(this.x, this.y, WIDTH, HEIGHT);
//			g.setColor(Color.WHITE);
			//炮筒
			switch(ptDir) {
			case U:
				g.drawImage(imgs.get("U"), x, y, null);
				break;
			case D:
				g.drawImage(imgs.get("D"), x, y, null);				
				break;
			case L:
				g.drawImage(imgs.get("L"), x, y, null);			
				break;
			case R:
				g.drawImage(imgs.get("R"), x, y, null);			
				break;
			case UL:
				g.drawImage(imgs.get("UL"), x, y, null);				
				break;
			case DL:
				g.drawImage(imgs.get("DL"), x, y, null);				
				break;
			case UR:
				g.drawImage(imgs.get("UR"), x, y, null);				
				break;
			case DR:
				g.drawImage(imgs.get("DR"), x, y, null);				
				break;
			}
		}else {
			tc.tanks.remove(this);
			return;
		}
		if(good && live)	bb.draw(g);
		g.setColor(c);
		move();
		
	}
	
	public void move() {
		
		this.oldX = x;
		this.oldY = y;
		
		switch(dir) {
		case U:
			y -= YSPEED;
			break;
		case D:
			y += YSPEED;
			break;
		case L:
			x -= XSPEED;
			break;
		case R:
			x += XSPEED;
			break;
		case UL:
			x -= XSPEED;
			y -= YSPEED;
			break;
		case DL:
			x -= XSPEED;
			y += YSPEED;
			break;
		case UR:
			x += XSPEED;
			y -= YSPEED;
			break;
		case DR:
			x += XSPEED;
			y += YSPEED;
			break;
		case STOP:
			break;
		}
		//坦克出界问题
		if(x < 0)	x = 0;
		if(y < 30)	y = 30;
		if(x + WIDTH > TankClient.GAME_WIDTH)	x =	TankClient.GAME_WIDTH - WIDTH;
		if(y + HEIGHT > TankClient.GAME_HEIGHT) y = TankClient.GAME_HEIGHT - HEIGHT;
		//坦克自动移动和打子弹.	
		if(!good) {
			Direction[] dirs = Direction.values();
			if(step == 0) {
				step = r.nextInt(12) + 3;
				int rn = r.nextInt(dirs.length);
				dir = dirs[rn];
			}
			step --;
			if(r.nextInt(42) > 38)	this.fire();
		}
		//炮筒的方向和坦克运动的方向一致.
		if(dir != Direction.STOP) ptDir = dir;
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key) {
		case KeyEvent.VK_W:
			bU = true;
			break;
		case KeyEvent.VK_S:
			bD = true;
			break;
		case KeyEvent.VK_A:
			bL = true;
			break;
		case KeyEvent.VK_D:
			bR = true;
			break;
		case KeyEvent.VK_J:
			fire();
			break;
		case KeyEvent.VK_K:
			superfire();
			break;
		case KeyEvent.VK_F2:
			if(this.good && !this.live) {
				this.live = true;
				this.hp = 100;
			}
			break;
		}
	
	locationDirection();	
	}
	
	private void locationDirection() {
		if(bU && !bD && !bL && !bR) {
			dir =Direction.U;
		}
		else if(!bU && bD && !bL && !bR) {
			dir =Direction.D;
		}	
		else if(!bU && !bD && bL && !bR) {
			dir =Direction.L;
		}	
		else if(!bU && !bD && !bL && bR) {
			dir =Direction.R;
		}	
		else if(!bU && !bD && !bL && !bR)	dir =Direction.STOP;
		else if(bU && !bD && bL && !bR) {
			dir =Direction.UL;
		}	
		else if(!bU && bD && bL && !bR)	{
			dir =Direction.DL;
		}
		else if(bU && !bD && !bL && bR)	{
			dir =Direction.UR;
		}
		else if(!bU && bD && !bL && bR)	{
			dir =Direction.DR;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key) {
		case KeyEvent.VK_W:
			bU = false;
			break;
		case KeyEvent.VK_S:
			bD = false;
			break;
		case KeyEvent.VK_A:
			bL = false;
			break;
		case KeyEvent.VK_D:
			bR = false;
			break;
		}
		
		locationDirection();	
	}
	public Missile fire() {
		if(!live)	return null;
		int x = this.x + Tank.WIDTH/2 - Missile.WIDTH/2;
		int y = this.y + Tank.HEIGHT/2 - Missile.HEIGHT/2;
		Missile m = new Missile(x, y, good, ptDir, tc);
		tc.missiles.add(m);
		return m;
	}
	
	public Missile fire(Direction dir) {
		if(!live)	return null;
		int x = this.x + Tank.WIDTH/2 - Missile.WIDTH/2;
		int y = this.y + Tank.HEIGHT/2 - Missile.HEIGHT/2;
		Missile m = new Missile(x, y, good, dir, tc);
		tc.missiles.add(m);
		return m;
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	public boolean hitWall(Wall wall) {
		if(live && this.getRect().intersects(wall.getRect())) {
			this.stay();
			return true;
		}
		return false;
	}
	
	private boolean hitTank(Tank tank) {
		if(this != tank && this.getRect().intersects(tank.getRect()) && live) {
			stay();
			return true;
		}
		return false;
	}
	
	public void hitTanks(java.util.List<Tank> tanks) {
		for(int i = 0; i<tanks.size(); i++) {
			hitTank(tanks.get(i));
		}
	}
	
	private void stay() {
		this.x = oldX;
		this.y = oldY;
	}
	
	private void superfire() {
		Direction[] dirs = Direction.values();
		for(int i = 0; i<8; i++) {
			fire(dirs[i]);
		}
		
	}
	private class BloodBar {
		
		void draw(Graphics g) {
			int w = WIDTH * hp / 100;
			Color c = g.getColor();
			g.setColor(Color.RED);
			g.drawRect(x, y-12, WIDTH, 10);
			g.fillRect(x, y-12, w, 10);
			g.setColor(c);
		}
	}
	
	public boolean eatBlood(Blood b) {
		if(this.getRect().intersects(b.getRect()) && b.isLive()) {
			b.setLive(false);
			this.hp = 100;
			return true;
		}
		return false;
	}
}

