import java.util.*;

class User {
    private String userId;
    private String pin;

    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
    }

    public String getUserId() {
        return userId;
    }

    public String getPin() {
        return pin;
    }
}

class ATM {
    private User currentUser;
    private List<String> transactionHistory;

    public ATM() {
        transactionHistory = new ArrayList<>();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        // Here you can perform validation of the user credentials against a database or any other mechanism
        // For simplicity, we will hardcode a single user with ID "admin" and PIN "1234"
        if (userId.equals("admin") && pin.equals("1234")) {
            currentUser = new User(userId, pin);
            showMainMenu(scanner);
        } else {
            System.out.println("Invalid user ID or PIN");
        }
    }

    private void showMainMenu(Scanner scanner) {
        boolean quit = false;
        while (!quit) {
            System.out.println("\n----- Main Menu -----");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    performWithdraw(scanner);
                    break;
                case 3:
                    performDeposit(scanner);
                    break;
                case 4:
                    performTransfer(scanner);
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showTransactionHistory() {
        System.out.println("\n----- Transaction History -----");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    private void performWithdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        // Perform the withdrawal logic here
        // You can add appropriate checks and update the transaction history accordingly
        // For simplicity, we will just display a message here
        System.out.println("Withdrawal of $" + amount + " successful.");
        transactionHistory.add("Withdrawal: -$" + amount);
    }

    private void performDeposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        // Perform the deposit logic here
        // You can add appropriate checks and update the transaction history accordingly
        // For simplicity, we will just display a message here
        System.out.println("Deposit of $" + amount + " successful.");
        transactionHistory.add("Deposit: +$" + amount);
    }

    private void performTransfer(Scanner scanner) {
        System.out.print("Enter the recipient's user ID: ");
        String recipientId = scanner.nextLine();
        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        // Perform the transfer logic here
        // You can add appropriate checks and update the transaction history accordingly
        // For simplicity, we will just display a message here
        System.out.println("Transfer of $" + amount + " to user " + recipientId + " successful.");
        transactionHistory.add("Transfer: -$" + amount + " to " + recipientId);
    }
}

public class ATMApplication {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
