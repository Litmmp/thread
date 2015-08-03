package my.thread.test;

public class SecondThread implements Runnable {

	private int i;

	/**
	 * @param args
	 */

	@Override
	public void run() {
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			// System.out.println(Thread.currentThread().getName() + " " + i);
			if (20 == i) {
				SecondThread st = new SecondThread();
				Thread thread1 = new Thread(st, "新线程1");
				thread1.start();
				Thread thread2 = new Thread(st, "新线程2");
				thread2.start();
				System.out.println(thread1.isAlive());
			}
		}
	}

}
