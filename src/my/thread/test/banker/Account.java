package my.thread.test.banker;

import java.util.concurrent.locks.ReentrantLock;

public class Account {

	private final ReentrantLock lock = new ReentrantLock();

	private String accountNo;
	private double balance;

	public Account() {

	}

	public Account(String accountNo, double balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void draw1(double drawAmount) {
		lock.lock();
		try {
			if (balance > drawAmount) {
				System.out.println(Thread.currentThread().getName()
						+ "取钱成功，取款金额：" + drawAmount);
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				balance -= drawAmount;
				System.out.println("\t余额为: " + balance);
			} else {
				System.out.println(Thread.currentThread().getName()
						+ "取钱失败，余额不足！");
			}
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}

	public synchronized void draw(double drawAmount) {
		if (balance > drawAmount) {
			System.out.println(Thread.currentThread().getName() + "取钱成功，取款金额："
					+ drawAmount);
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			balance -= drawAmount;
			System.out.println("\t余额为: " + balance);
		} else {
			System.out.println(Thread.currentThread().getName() + "取钱失败，余额不足！");
		}
	}

	@Override
	public int hashCode() {
		return accountNo.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (null != obj && obj.getClass() == Account.class) {
			Account target = (Account) obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}

}
