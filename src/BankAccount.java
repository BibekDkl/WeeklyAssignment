public abstract class BankAccount {
    private String accountNumber;
    private String AccountHolderName;
    protected double balance;

    public BankAccount(String accountNumber, String AccountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.AccountHolderName = AccountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return AccountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws InvalidDepositException {
        if (amount <= 0) {
            throw new InvalidDepositException();
        }
        balance += amount;
        System.out.println("Successfully deposited: " + amount);
    }

    // Abstract method - implemented differently in subclasses
    public abstract void withdraw(double amount) throws InsufficientBalanceException;

    // Abstract method for showing account info
    public abstract void displayInfo();
}
