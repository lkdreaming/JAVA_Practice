import java.awt.*;
public class Explode {
	int x,y;
	private boolean live = true;
	int[] diameter = {10,20,30,40,50,60,70,80,70,60,50,40,30,20,10};
	int step = 0;
	TankClient tc ;
	Explode(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	Explode(int x, int y, TankClient tc) {
		
		this(x, y);
		this.tc = tc;
		
	}
	
	public void draw(Graphics g) {
		
		Color c = g.getColor();
		
		
		
		if(step == diameter.length) {
			
			live = false;
			step = 0;
			return;
			
		}
		
		if(live) {
			
			g.setColor(Color.ORANGE);
			g.fillOval(x, y, diameter[step], diameter[step]);
			step ++;
			g.setColor(c);
			
		}else {
			
			tc.explodes.remove(this);
			return;
		
		}
		
		
		
		
	}
}
