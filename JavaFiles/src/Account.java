import java.io.Serializable;

public class Account implements Serializable {
    private String accountName;
    private int accountID;
    private double balance;
    private Date date;
    //public final long serailVersionUid = 4L;

    public Account(String accountName, int accountID, double balance, Date d) {
        this.accountName = accountName;
        this.accountID = accountID;
        this.balance = balance;
        this.date = d;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return this.getAccountName() + " " + this.getAccountID() + " " + this.getBalance() + " " + this.getDate();
    }
}