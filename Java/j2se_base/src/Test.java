import java.util.Date;


public class Test {
	public static void main(String[] args) {
		Test test = new Test();
		test.showTime();
	}
	
	public void showTime() {
		
		new Thread(new ShowTimeThread()).start();
		
	}
	
	public class ShowTimeThread implements Runnable {

		@Override
		public void run() {
			while(true) {
				Date date = new Date();
				System.out.println(date);
				try {
					Thread.sleep(1000);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
