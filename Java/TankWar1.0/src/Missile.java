import java.awt.*;

public class Missile extends Frame{
	
	int x, y;
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	public static final int MISSILE_WIDTH = 10;
	public static final int MISSILE_HEIGHT = 10;
	
	Missile(int x, int y, Tank.Direction dir) {
		
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	Tank.Direction dir = Tank.Direction.D;
	public void draw(Graphics g) {
		
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.fillOval(this.x, this.y, MISSILE_WIDTH, MISSILE_HEIGHT);
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
