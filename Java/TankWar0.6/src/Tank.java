import java.awt.*;
import java.awt.event.*;

public class Tank {
	int x,y;
	public static final int TANK_WIDTH = 30;
	public static final int TANK_HEIGHT = 30;
	public static final int TANK_XSPEED = 5;
	public static final int TANK_YSPEED = 5;
	
	
	Tank(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	public void draw(Graphics g) {
		
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, TANK_WIDTH, TANK_HEIGHT);
		g.setColor(c);
		
	}
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		switch(key) {
		
		case KeyEvent.VK_W:
			y -= TANK_YSPEED;
			break;
		case KeyEvent.VK_S:
			y += TANK_YSPEED;
			break;
		case KeyEvent.VK_A:
			x -= TANK_XSPEED;
			break;
		case KeyEvent.VK_D:
			x += TANK_XSPEED;
			break;
		
		
		}
	
	}
	
}
