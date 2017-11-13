import java.awt.*;

public class Missile {
	
	int x, y;
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	private Tank.Direction dir = null;
	private boolean live = true;
	Missile(int x, int y, Tank.Direction dir) {
		
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	
	public void draw(Graphics g) {
		
		Color c = g.getColor();
		g.setColor(Color.WHITE);
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
		}
	}
	
}
