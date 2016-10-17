class Account {
	int balance;
	Account(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return this.balance;
	}
}

class SavingsAccount extends Account {
	int fixedDeposit;

	SavingsAccount(int balance, int fixedDeposit) {
		super(balance);
		this.fixedDeposit = fixedDeposit;
	}

	public int getBalance() {
		return super.getBalance() + fixedDeposit;
	}
}

class CurrentAccount extends Account {
	int cashCredit;
	CurrentAccount(int balance, int cashCredit) {
		super(balance);
		this.cashCredit = cashCredit;
	}

	public int getBalance() {
		return super.getBalance() + cashCredit;
	}
}

public class Bank {
	public static void main(String[] args) {
		
	}
}