package my.thread.test.account;

class DrawThread extends Thread {
	private Account account;
	private double drawAmount;

	public DrawThread(String name, Account account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			account.draw(drawAmount);
		}
	}
}

class DepositThread extends Thread {
	private Account account;
	private double depositAmount;

	public DepositThread(String name, Account account, double depositAmount) {
		super(name);
		this.account = account;
		this.depositAmount = depositAmount;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			account.deposit(depositAmount);
		}
	}
}

public class DrawDepositTest {
	public static void main(String[] args) {
		Account account = new Account("112233", 0);
		new DrawThread("取钱者", account, 800).start();
		new DepositThread("甲", account, 800).start();
		new DepositThread("乙", account, 800).start();
		new DepositThread("丙", account, 800).start();
	}
}
