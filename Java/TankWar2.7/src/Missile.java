import java.awt.*;
import java.util.List;
public class Missile {
	int x, y;
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	private Direction dir = null;
	private boolean live = true;
	private boolean good;
	TankClient tc;
	
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
			Color c = g.getColor();
			if(good) g.setColor(Color.WHITE);
			else g.setColor(Color.orange);
			g.fillOval(this.x, this.y, WIDTH, HEIGHT);
			g.setColor(c);
			move();
		}else {
			tc.missiles.remove(this);
			return;
		}
	//�ӵ��ƶ�	
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
		//�����ӵ�����
		if(x < 0 || y < 0 || x > TankClient.GAME_WIDTH - WIDTH  || y > TankClient.GAME_HEIGHT - HEIGHT ) {
			this.live = false;
		} 
	}
	//����ӵ�����߿�
	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	//��߿��ཻ����ײ
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
	//������ײ̹�˼���.
	public void hitTanks(List<Tank> tanks) {
		for(int i = 0; i < tanks.size(); i++) {
			hitTank(tanks.get(i));
		}
	}
	//�ӵ�ײǽ
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