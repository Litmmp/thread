package my.thread.test.banker;

public class DrawThread extends Thread {
	private Account account;
	private double drawAmount;

	public DrawThread(String name, Account account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setDrawAmount(double drawAmount) {
		this.drawAmount = drawAmount;
	}

	public double getDrawAmount() {
		return drawAmount;
	}

	@Override
	public void run() {
		account.draw1(drawAmount);
	}
}