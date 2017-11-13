import java.awt.*;
public class Blood {
	int x, y, w ,h;
	private boolean live = true;
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}

	int[][] pos = {{250, 250}, {250, 300}, {280, 380}, {192, 400}, {263, 369}, {388, 422}, {211, 152}, {234, 52}, {98,392}, {85,400}, {136, 276}, {367,50}, {11,400}};
	int step = 0;
	Blood() {
		this.x = pos[0][0];
		this.y = pos[0][1];
		this.w = 15;
		this.h = 15;
	}
	public void draw(Graphics g) {
		if(live) {
			Color c = g.getColor();
			g.setColor(Color.MAGENTA);
			g.fillRect(x, y, w, h);
			g.setColor(c);
			move();
		}else return;
		
	}
	
	private void move() {
		step ++;
		if(step == pos.length) {
			step = 0;
		}else {
			this.x = pos[step][0];
			this.y = pos[step][1];
		}
		
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, w, h);
	}
}
