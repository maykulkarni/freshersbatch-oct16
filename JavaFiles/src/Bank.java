class Account_ {
    int balance;

    Account_(int balance) {
        this.balance = balance;
	}

	public int getBalance() {
		return this.balance;
	}
}

class SavingsAccount extends Account_ {
    int fixedDeposit;

	SavingsAccount(int balance, int fixedDeposit) {
		super(balance);
		this.fixedDeposit = fixedDeposit;
	}

	public int getBalance() {
		return super.getBalance() + fixedDeposit;
	}
}

class CurrentAccount extends Account_ {
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