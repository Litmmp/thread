package my.thread.test;

public class FirstThread extends Thread {

	private int i;

	@Override
	public void run() {
		for (; i < 100; i++) {
			System.out.println(this.getName() + " " + i);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			//System.out.println(Thread.currentThread().getName() + " " + i);
			if (20 == i) {
				new FirstThread().start();
				new FirstThread().start();
			}
		}
	}

}
