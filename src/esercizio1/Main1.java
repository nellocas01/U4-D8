package esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main1 {
	public static Logger logger = LoggerFactory.getLogger(Main1.class);

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();

		t1.setName("#-Primo");
		t2.setName("@-Secondo");

		t1.start();
		t2.start();
	}

}
