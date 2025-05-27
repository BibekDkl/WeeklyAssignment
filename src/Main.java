import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Greeting
        System.out.println("Welcome to Rural Bank of Nepal");

        // Customer info
        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        // Creating customer and accounts
        Customer customer = new Customer(customerName);

        SavingsAccount savings = new SavingsAccount("SAV001", customerName, 0);
        CurrentAccount current = new CurrentAccount("CUR001", customerName, 5000);

        customer.addAccount(savings);
        customer.addAccount(current);

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Add Interest to Savings");
            System.out.println("4. View Account Details");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("Thank you for banking with us!");
                break;
            }

            System.out.print("Select Account (1: Savings, 2: Current): ");
            int accChoice = sc.nextInt();
            BankAccount selectedAccount = (accChoice == 1) ? savings : current;

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double depAmount = sc.nextDouble();
                        selectedAccount.deposit(depAmount);
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withAmount = sc.nextDouble();
                        selectedAccount.withdraw(withAmount);
                        break;

                    case 3:
                        if (selectedAccount instanceof SavingsAccount) {
                            ((SavingsAccount) selectedAccount).addInterest();
                        } else {
                            System.out.println("Interest can only be added to a savings account.");
                        }
                        break;

                    case 4:
                        customer.showAccounts();
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Operation failed: " + e.getMessage());
            }
        }

        sc.close();
    }
}
