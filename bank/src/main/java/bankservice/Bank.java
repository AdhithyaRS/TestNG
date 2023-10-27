package bankservice;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public BankAccount createAccount() {
        BankAccount account = new BankAccount();
        accounts.add(account);
        return account;
    }

    public BankAccount getAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public List<BankAccount> getAllAccounts() {
        return accounts;
    }

    public double getTotalBalance() {
        double total = 0.0;
        for (BankAccount account : accounts) {
            total += account.getBalance();
        }
        return total;
    }
}
