package bank;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import bankservice.Bank;
import bankservice.BankAccount;

class BankTestTest {

	private static Bank bank;
	@BeforeAll
    public static void set() {
        bank = new Bank();
    }
	@Test
    public void testCreatingNewAccount() {
        BankAccount account = bank.createAccount();
        assertNotNull(account);
    }

    @Test
    public void testDepositingFunds() {
        
        BankAccount account = bank.createAccount();
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawingFunds() {
        
        BankAccount account = bank.createAccount();
        account.deposit(100.0);
        assertTrue(account.withdraw(50.0));
        assertEquals(50.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawalWithInsufficientBalance() {
        
        BankAccount account = bank.createAccount();
        account.deposit(100.0);
        assertFalse(account.withdraw(150.0));
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    public void testCheckingAccountBalance() {
        
        BankAccount account = bank.createAccount();
        account.deposit(200.0);
        assertEquals(200.0, account.getBalance(), 0.001);
    }

    @Test
    public void testCheckingTotalBalance() {
    	Bank bank = new Bank();
        BankAccount account1 = bank.createAccount();
        BankAccount account2 = bank.createAccount();
        account1.deposit(100.0);
        account2.deposit(200.0);
        assertEquals(300.0, bank.getTotalBalance(), 0.001);
    }
    @Test
    public void testUniqueAccountNumbers() {
        
        List<Integer> accountNumbers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            BankAccount account = bank.createAccount();
            int accountNumber = account.getAccountNumber();
            assertFalse(accountNumbers.contains(accountNumber));
            accountNumbers.add(accountNumber);
        }
    }
    @Test
    public void testRandomOperationsOn1000Accounts() {
        
        Random random = new Random();
        List<BankAccount> accounts = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            BankAccount account = bank.createAccount();
            accounts.add(account);
        }
        Map<Integer, Double> initialBalances = new HashMap<>();
        for (BankAccount account : accounts) {
            initialBalances.put(account.getAccountNumber(), account.getBalance());
        }
        for (int i = 0; i < 10000; i++) {
            BankAccount account = accounts.get(random.nextInt(1000));
            double amount = random.nextDouble() * 1000;
            int operation = random.nextInt(2);

            if (operation == 0) {
                account.deposit(amount);
                initialBalances.put(account.getAccountNumber(), initialBalances.get(account.getAccountNumber()) + amount);
            } else {
                double initialBalance = initialBalances.get(account.getAccountNumber());
                if (initialBalance >= amount) {
                    account.withdraw(amount);
                    initialBalances.put(account.getAccountNumber(), initialBalance - amount);
                }else {
//                	assertFalse(account.withdraw(initialBalance));
//                    assertEquals(initialBalance, account.getBalance(), 0.001);
                	testWithdrawalWithInsufficientBalance(account, amount, initialBalance);
                }
            }
        }
        for (BankAccount account : accounts) {
            double actualBalance = account.getBalance();
            double expectedBalance = initialBalances.get(account.getAccountNumber());
            assertEquals(expectedBalance, actualBalance, 0.001);
        }
    }
    private void testWithdrawalWithInsufficientBalance(BankAccount account, double amount, double initialBalance) {
        assertFalse(account.withdraw(amount));
        assertEquals(initialBalance, account.getBalance(), 0.001);
    }
}