import java.awt.*;
import java.util.List;
public class Missile {
	int x, y;
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	private Tank.Direction dir = null;
	private boolean live = true;
	private boolean good;
	TankClient tc;
	
	Missile(int x, int y, Tank.Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	Missile(int x, int y, Tank.Direction dir, TankClient tc) {
		this(x, y, dir);
		this.tc = tc;
	}
	
	Missile(int x, int y, boolean good, Tank.Direction dir, TankClient tc) {
		this.x = x;
		this.y = y;
		this.good = good;
		this.dir = dir;
		this.tc = tc;
	}
	
	public void draw(Graphics g) {
		if(live) {
			Color c = g.getColor();
			g.setColor(Color.WHITE);
			g.fillOval(this.x, this.y, WIDTH, HEIGHT);
			g.setColor(c);
			move();
		}else {
			tc.missiles.remove(this);
			return;
		}
	//子弹移动	
	}
	public void move() {
		
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
		if(this.getRect().intersects(t.getRect()) && t.isLive() && this.good != t.good) {
			this.live = false;
			t.setLive(false);
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
