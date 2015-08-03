package my.thread.test.account;

public class Account {

	private String accountNo;
	private double balance;

	private boolean flag = false;

	public Account() {
	}

	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public double getBalance() {
		return balance;
	}

	// 取钱
	public synchronized void draw(double drawAmount) {
		try {
			if (!flag) {
				wait();
			} else {
				System.out.println(Thread.currentThread().getName() + " 取钱:"
						+ drawAmount);
				balance -= drawAmount;
				System.out.println("账户余额: " + balance);
				flag = false;
				notifyAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 存钱
	public synchronized void deposit(double depositAmount) {
		try {
			if (flag) {
				wait();
			} else {
				System.out.println(Thread.currentThread().getName() + " 存款: "
						+ depositAmount);
				balance += depositAmount;
				System.out.println("账户余额: " + balance);
				flag = true;
				notifyAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Override
//	public int hashCode() {
//		return accountNo.hashCode();
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (null != obj && obj.getClass() == Account.class) {
//			Account target = (Account) obj;
//			return target.getAccountNo().equals(accountNo);
//		}
//		return false;
//	}
}
