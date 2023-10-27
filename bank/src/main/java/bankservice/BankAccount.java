package bankservice;

public class BankAccount {
	private static int uniqueAccountNumber = 1;

    private int accountNumber;
    private double balance;

    public BankAccount() {
        this.accountNumber = uniqueAccountNumber++;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true; // Withdrawal successful
        }
        return false; // Withdrawal failed
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
