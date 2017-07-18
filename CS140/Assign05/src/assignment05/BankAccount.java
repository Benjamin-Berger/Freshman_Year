package assignment05;
/**
   A bank account has a balance and a mechanism for applying interest or fees at 
   the end of the month.
 */
public abstract class BankAccount {
    private double balance;
    private int accountNumber;

    /**
     * Constructs a bank account with zero balance.
     * @param aBalance the initial balance
     * @param anAccNum the number for this account
     */
    public BankAccount(double aBalance, int anAccNum) {
        balance = aBalance;
        accountNumber = anAccNum;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Makes a deposit into this account.
     * @param amount the amount of the deposit
     */
    public void deposit(double amount) {
        balance = balance + amount;
    }

    /**
     * Makes a withdrawal from this account, or charges a penalty if 
     * sufficient funds are not available.
     * @param amount the amount of the withdrawal
     */
    public void withdraw(double amount) {
        balance = balance - amount;
    }

    /**
     * Carries out the end of month processing that is appropriate
     * for this account.
     */
    public abstract void monthEnd();

    /**
     * Gets the current balance of this bank account.
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }
}