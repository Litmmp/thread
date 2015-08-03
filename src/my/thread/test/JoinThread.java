package my.thread.test;

public class JoinThread extends Thread {

	public JoinThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(getName() + " " + i);
		}
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		new JoinThread("子线程").start();
		for (int i = 0; i < 1000; i++) {
			if (20 == i) {
				JoinThread jt = new JoinThread("被join的线程");
				jt.start();
				jt.join();
			}
			System.out.println(Thread.currentThread().getName() + " --- " + i);
		}
	}

}
