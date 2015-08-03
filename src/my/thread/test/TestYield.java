package my.thread.test;

public class TestYield extends Thread {
	public TestYield() {

	}

	public TestYield(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(getName() + " " + i);
			if (20 == i) {
				Thread.yield();
			}
		}
	}

	public static void main(String[] args) {

		TestYield ty1 = new TestYield("---高级---");
		ty1.setPriority(Thread.MAX_PRIORITY);

		TestYield ty2 = new TestYield("***低级***");
		ty2.setPriority(Thread.MIN_PRIORITY);

		ty1.start();
		ty2.start();
	}
}
