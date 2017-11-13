import java.awt.*;
import java.awt.event.*;

public class Tank {
	int x,y;
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	public static final int XSPEED = 5;
	public static final int YSPEED = 5;
	private boolean bU,bD,bL,bR;
	enum Direction{U,D,L,R,UL,DL,UR,DR,STOP};
	Direction dir = Direction.STOP;
	
	Tank(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	public void draw(Graphics g) {
		
		
		
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(this.x, this.y, WIDTH, HEIGHT);
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
		
		
		}
	
	locationDirection();	
	}
	
	private void locationDirection() {
		
		if(bU && !bD && !bL && !bR)	dir =Direction.U;
		else if(!bU && bD && !bL && !bR)	dir =Direction.D;
		else if(!bU && !bD && bL && !bR)	dir =Direction.L;
		else if(!bU && !bD && !bL && bR)	dir =Direction.R;
		else if(!bU && !bD && !bL && !bR)	dir =Direction.STOP;
		else if(bU && !bD && bL && !bR)	dir =Direction.UL;
		else if(!bU && bD && bL && !bR)	dir =Direction.DL;
		else if(bU && !bD && !bL && bR)	dir =Direction.UR;
		else if(!bU && bD && !bL && bR)	dir =Direction.DR;
	}
	
}
