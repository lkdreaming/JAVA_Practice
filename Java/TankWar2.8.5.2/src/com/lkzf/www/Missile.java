package com.lkzf.www;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Missile {
	int x, y;
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	private Direction dir = null;
	private boolean live = true;
	private boolean good;
	private static Toolkit tk;
	private static Image[] missileImages;
	private static Map<String, Image> imgs = new HashMap<String, Image>();
	TankClient tc;
	static {
		tk = Toolkit.getDefaultToolkit();
		missileImages = new Image[]{
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileU.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileD.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileL.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileR.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileUL.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileDL.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileUR.gif")),
				tk.getImage(Missile.class.getClassLoader().getResource("images/missileDR.gif"))
		};
		imgs.put("U", missileImages[0]);
		imgs.put("D", missileImages[1]);
		imgs.put("L", missileImages[2]);
		imgs.put("R", missileImages[3]);
		imgs.put("UL", missileImages[4]);
		imgs.put("DL", missileImages[5]);
		imgs.put("UR", missileImages[6]);
		imgs.put("DR", missileImages[7]);
	}
	Missile(int x, int y, Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	Missile(int x, int y, Direction dir, TankClient tc) {
		this(x, y, dir);
		this.tc = tc;
	}
	
	Missile(int x, int y, boolean good, Direction dir, TankClient tc) {
		this.x = x;
		this.y = y;
		this.good = good;
		this.dir = dir;
		this.tc = tc;
	}
	
	public void draw(Graphics g) {
		if(live) {
			
			move(g);
		}else {
			tc.missiles.remove(this);
			return;
		}
	//子弹移动	
	}
	
	public void move(Graphics g) {
		
		switch(dir) {
		case U:
			g.drawImage(imgs.get("U"), x, y, null);
			y -= YSPEED;
			break;
		case D:
			g.drawImage(imgs.get("D"), x, y, null);
			y += YSPEED;
			break;
		case L:
			g.drawImage(imgs.get("L"), x, y, null);
			x -= XSPEED;
			break;
		case R:
			g.drawImage(imgs.get("R"), x, y, null);
			x += XSPEED;
			break;
		case UL:
			g.drawImage(imgs.get("UL"), x, y, null);
			x -= XSPEED;
			y -= YSPEED;
			break;
		case DL:
			g.drawImage(imgs.get("DL"), x, y, null);
			x -= XSPEED;
			y += YSPEED;
			break;
		case UR:
			g.drawImage(imgs.get("UR"), x, y, null);
			x += XSPEED;
			y -= YSPEED;
			break;
		case DR:
			g.drawImage(imgs.get("DR"), x, y, null);
			x += XSPEED;
			y += YSPEED;
			break;
		}
		//处理子弹出界
		if(x < 0 || y < 0 || x > TankClient.GAME_WIDTH - WIDTH  || y > TankClient.GAME_HEIGHT - HEIGHT ) {
			this.live = false;
		} 
	}
	//获得子弹的外边框
	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	//外边框相交则相撞
	public boolean hitTank(Tank t) {
		if(this.getRect().intersects(t.getRect()) && t.getHp() && this.good != t.isGood()) {
			if(t.isGood()) {
				if(t.getLife() <= 0) {
					t.setLive(false);
				}else {
					t.setHp(t.getLife() - 20);
				}
			} else {
				t.setLive(false);
			}
			
			this.live = false;
			tc.explodes.add(new Explode(x, y, tc));
			return true;
		}
		return false;
	}
	//处理相撞坦克集合.
	public void hitTanks(List<Tank> tanks) {
		for(int i = 0; i < tanks.size(); i++) {
			hitTank(tanks.get(i));
		}
	}
	//子弹撞墙
	public boolean hitWall(Wall wall) {
		if(this.getRect().intersects(wall.getRect()) && this.live) {
			this.live = false;
			return true;
		}
		return false;
	}
	
	public boolean hitMissile(Missile missile) {
		if(this.getRect().intersects(missile.getRect()) && this.live && this.good != missile.good) {
			this.live = false;
			return true;
		}
		return false;
	}
	/*
	public void hitMissiles(List<Missile> missiles) {
		for(int i = 0; i<missiles.size(); i++) {
			hitMissile(missiles.get(i));
		}
	}
	*/
}
