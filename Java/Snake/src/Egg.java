import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Egg {
	int row, col;
	int weight = Yard.BLOCK_SIZE;
	int height = Yard.BLOCK_SIZE;
	private static Random r = new Random();
	
	Egg(int row,int col) {
		this.row = row;
		this.col = col;
	}
	
	public void reAppear() {
		this.row = r.nextInt(Yard.ROWS - 2) + 2;
		this.col = r.nextInt(Yard.COLS);
	}
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(col * Yard.BLOCK_SIZE, row * Yard.BLOCK_SIZE, weight, height);
		g.setColor(c);
	}
	public Rectangle getRect() {
		return new Rectangle(col * Yard.BLOCK_SIZE, row * Yard.BLOCK_SIZE, weight, height);
	}

}
