package my.thread.test;

public class DaemonThread extends Thread {

	public DaemonThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		DaemonThread dt = new DaemonThread("后台线程");
		dt.setDaemon(true);
		dt.start();
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

}
