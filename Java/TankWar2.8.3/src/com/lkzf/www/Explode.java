package com.lkzf.www;
import java.awt.*;
public class Explode {
	int x,y;
	private boolean live = true;
	private boolean init = false;
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	private static Image[] imgs = {
		tk.getImage(Explode.class.getClassLoader().getResource("images/0.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/1.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/2.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/3.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/4.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/5.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/6.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/7.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/8.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/9.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/10.gif"))
	};
	//int[] diameter = {10,20,30,40,50,60,70,80,70,60,50,40,30,20,10};
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
		
		if(!init) {
			for (int i = 0; i < imgs.length; i++) {
				g.drawImage(imgs[i], x, y, null);
			}
			init = true;
		}
		
		Color c = g.getColor();
		
		if(step == imgs.length) {
			live = false;
			step = 0;
			return;
		}
		
		if(live) {
			g.drawImage(imgs[step], x, y, null);
			step++;
		}else {
			tc.explodes.remove(this);
			return;
		}
		
		
		
		
	}
}
