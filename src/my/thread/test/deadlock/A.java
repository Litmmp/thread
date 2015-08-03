package my.thread.test.deadlock;

public class A {
	public synchronized void foo(B b) {
		System.out.println("当前线程名: " + Thread.currentThread().getName()
				+ " 进入了A线程的foo方法.");
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("当前线程名: " + Thread.currentThread().getName()
				+ " 企图调用B实例的last方法.");
		b.last();
	}

	public synchronized void last() {
		System.out.println("进入了A实例的last方法内部.");
	}
}
