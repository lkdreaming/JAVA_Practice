import java.awt.*;

public class Tank {
	int x,y;
	public static final int WIDTH = 30;
	public static final int HEIGHT = 30;
	Tank(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	public void draw(Graphics g) {
		
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(this.x, this.y, this.WIDTH, this.HEIGHT);
		g.setColor(c);
	}
	
}
