import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Tank {
	private int x, y, oldX, oldY;
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	public static final int XSPEED = 5;
	public static final int YSPEED = 5;
	private boolean bL=false, bU=false, bR=false, bD = false;
	enum Direction{U,D,L,R,UL,DL,UR,DR,STOP};
	private Direction ptDir = Direction.D;
	private Direction dir = Direction.STOP;
	TankClient tc = null;
	public boolean good;
	private boolean live = true;
	private static Random r = new Random();
	private int step = r.nextInt(12);
	public boolean isLive() {
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
			if(good)	g.setColor(Color.RED);
			else	g.setColor(Color.BLUE);
			g.fillOval(this.x, this.y, WIDTH, HEIGHT);
			g.setColor(Color.WHITE);
			//炮筒
			switch(ptDir) {
			case U:
				g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH / 2, y);
				break;
			case D:
				g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH / 2, y + HEIGHT);
				break;
			case L:
				g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x , y + HEIGHT / 2);
				break;
			case R:
				g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH , y + HEIGHT / 2);
				break;
			case UL:
				g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x , y);
				break;
			case DL:
				g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x  , y + HEIGHT);
				break;
			case UR:
				g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH , y);
				break;
			case DR:
				g.drawLine(x + WIDTH / 2, y + HEIGHT / 2, x + WIDTH , y + HEIGHT);
				break;
			}
		}else {
			tc.tanks.remove(this);
			return;
		}
		
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
	
	private void stay() {
		this.x = oldX;
		this.y = oldY;
	}
}
