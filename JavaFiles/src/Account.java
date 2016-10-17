package src;
public class Account {
    static int balance;

    static {
        balance = 0;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void print() {
        System.out.println("balance is : " + balance);
    }

    public static void main(String[] args) {

    }
}