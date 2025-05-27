import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<BankAccount> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    public void showAccounts() {
        System.out.println("Accounts of " + name + ":");
        for (BankAccount acc : accounts) {
            acc.displayInfo();
        }
    }
}
