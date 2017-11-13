import java.awt.*;

public class TankClient {
	static String TITLE = "坦克大战v0.1";
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new TankClient().launchframe();
	}
	public void launchframe() {
		Frame f = new Frame();
		f.setSize(800, 600);
		f.setLocation(300, 500);
		f.setBackground(Color.BLACK);
		f.setTitle(TITLE);
		f.setResizable(false);
		f.setVisible(true);
	}

}
