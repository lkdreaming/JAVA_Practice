import java.awt.*;
import java.util.List;
public class Missile {
	
	int x, y;
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	public Dir dir = null;
	boolean live = true;
	boolean good;
	TankClient tc;
	int tankId;
	
	Missile(int tankId, int x, int y, boolean good, Dir dir) {
		this.tankId = tankId;
		this.x = x;
		this.y = y;
		this.good = good;
		this.dir = dir;
	}
	Missile(int tankId, int x, int y, boolean good, Dir dir, TankClient tc) {
		this(tankId, x, y, good, dir);
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
		
		if(x < 0 || y < 0 || x > TankClient.GAME_WIDTH - WIDTH  || y > TankClient.GAME_HEIGHT - HEIGHT ) {
			
			this.live = false;
			
		} 
	}
	
	public Rectangle getRect() {
	
		return new Rectangle(x, y, WIDTH, HEIGHT);
		
	}
	
	public boolean hitTank(Tank t) {
		
		if(this.getRect().intersects(t.getRect()) && t.isLive() && this.good != t.good) {
			
			this.live = false;
			t.setLive(false);
			tc.explodes.add(new Explode(x, y, tc));
			TankDeadMsg tdmMsg = new TankDeadMsg (t);
			tc.nc.send(tdmMsg);
			return true;
			
		}
		
		return false;
	}
	
	public void hitTanks(List<Tank> tanks) {
		
		for(int i = 0; i < tanks.size(); i++) {
			
			hitTank(tanks.get(i));
			
		}
		
	}
}
