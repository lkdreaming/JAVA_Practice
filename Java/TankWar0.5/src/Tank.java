import java.awt.*;

public class Tank {
	int x,y;
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	public static final int XSPEED = 5;
	public static final int YSPEED = 5;
	
	Tank(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	public void draw(Graphics g) {
		
		
		
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(this.x, this.y, WIDTH, HEIGHT);
		g.setColor(c);
		x += XSPEED;
		y += YSPEED;
		
		
	}
	
}
