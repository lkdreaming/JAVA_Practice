import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Tank {
	private int x,y;
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	public static final int XSPEED = 5;
	public static final int YSPEED = 5;
	private boolean bL=false, bU=false, bR=false, bD = false;
	
	private Dir ptDir = Dir.D;
	private Dir dir = Dir.STOP;
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
		this.good = good;
		this.tc = tc;
		
	}
	public void draw(Graphics g) {
		
		Color c = g.getColor();
		if(live) {
			
			if(good)	g.setColor(Color.RED);
			else	g.setColor(Color.BLUE);
			g.fillOval(this.x, this.y, WIDTH, HEIGHT);
			g.setColor(Color.WHITE);
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
			
			Dir[] dirs = Dir.values();
			if(step == 0) {
				
				step = r.nextInt(12) + 3;
				int rn = r.nextInt(dirs.length);
				dir = dirs[rn];
				
			}
			step --;
			if(r.nextInt(42) > 38)	this.fire();
			
		}
		if(dir != Dir.STOP) ptDir = dir;
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
			
			dir =Dir.U;
			
		}
		else if(!bU && bD && !bL && !bR) {
			
			dir =Dir.D;
			
		}	
		else if(!bU && !bD && bL && !bR) {
			
			dir =Dir.L;
			
		}	
		else if(!bU && !bD && !bL && bR) {
			
			dir =Dir.R;
			
		}	
		else if(!bU && !bD && !bL && !bR)	dir =Dir.STOP;
		else if(bU && !bD && bL && !bR) {
			
			dir =Dir.UL;
			
		}	
		else if(!bU && bD && bL && !bR)	{
			
			dir =Dir.DL;
			
		}
		else if(bU && !bD && !bL && bR)	{
			
			dir =Dir.UR;
			
		}
		else if(!bU && bD && !bL && bR)	{
			
			dir =Dir.DR;
			
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
	/*
	public void tankDead() {
		
		if(!this.live)
		
	}
	*/
}
