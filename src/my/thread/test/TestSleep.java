package my.thread.test;

import java.util.Date;

public class TestSleep {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + ": " + new Date());
			Thread.sleep(1000);
		}

	}
}
