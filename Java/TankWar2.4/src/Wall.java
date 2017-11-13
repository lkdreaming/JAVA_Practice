import java.awt.*;
public class Wall {
	
	int x, y, w, h;
	//public static int HEIGHT = 100;
	//public static int WIDTH = 200;
	
	Wall(int x, int y,int w, int h) {
		
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public void draw(Graphics g) {
		
		Color c = g.getColor();
		g.setColor(Color.GREEN);
		g.fillRect(x, y, w, h);
		g.setColor(c);
		
	}
	
	public Rectangle getRect() {
		
		return new Rectangle(this.x, this.y, this.w, this.h);
		
	}
	
	
}
