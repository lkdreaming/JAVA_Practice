import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.SwingUtilities; 


public class TankWarClient extends JFrame {
	private static int WIDTH = 800;
	private static int HEIGHT = 600;
	
	
	
	public void launchframe() {
		this.getContentPane().setBackground(Color.BLUE);
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setVisible(true);
		this.setTitle("TankWar");
		this.setLocation(200, 100);
	}
	
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
	}
	
	public static void main(String[] args) {
		TankWarClient tc = new TankWarClient();
		tc.launchframe();
	}
}
