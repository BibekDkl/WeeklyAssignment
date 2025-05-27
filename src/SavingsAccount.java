public class SavingsAccount extends BankAccount {
    private double interestRate = 0.04; // 4% interest

    public SavingsAccount(String accountNumber, String AccountHolderName, double balance) {
        super(accountNumber, AccountHolderName, balance);
    }

    public void addInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest of " + interest + " added to savings account.");
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException();
        }
        balance -= amount;
        System.out.println("Successfully withdrawn: " + amount);
    }

    @Override
    public void displayInfo() {
        System.out.println("Savings Account - Holder: " + getAccountHolderName() +
                ", Acc#: " + getAccountNumber() +
                ", Balance: Rs. " + getBalance());
    }
}
