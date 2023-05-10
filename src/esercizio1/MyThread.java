package esercizio1;

public class MyThread extends Thread {

	@Override
	public void run() {
		for (int i = 1; i < 11; i++) {
			Main1.logger.info("" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Main1.logger.error(getName());
			}
		}
	}

}
