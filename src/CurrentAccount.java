public class CurrentAccount extends BankAccount {
    private double overdraftLimit = 5000; // Rs. 5000 overdraft allowed

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > (balance + overdraftLimit)) {
            throw new InsufficientBalanceException();
        }
        balance -= amount;
        System.out.println("Successfully withdrawn: " + amount);
    }

    @Override
    public void displayInfo() {
        System.out.println("Current Account - Holder: " + getAccountHolderName() +
                ", Acc#: " + getAccountNumber() +
                ", Balance: Rs. " + getBalance());
    }
}
