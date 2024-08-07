import java.util.Scanner;

public class BankingApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 1000; // Initial balance

        while (true) {
            System.out.println("\nBanking Application");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    try {
                        balance = deposit(balance, depositAmount);
                        System.out.println("Deposit successful. New balance: " + balance);
                    } catch (NegativeDepositException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    try {
                        balance = withdraw(balance, withdrawalAmount);
                        System.out.println("Withdrawal successful. New balance: " + balance);
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Your current balance is: " + balance);
                    break;
                case 4:
                    System.out.println("Exiting application...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Deposit method
    static double deposit(double balance, double amount) throws NegativeDepositException {
        if (amount < 0) {
            throw new NegativeDepositException("Cannot deposit a negative amount.");
        }
        return balance + amount;
    }

    // Withdraw method
    static double withdraw(double balance, double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds.");
        }
        return balance - amount;
    }
}

// Custom exception for negative deposit
class NegativeDepositException extends Exception {
    public NegativeDepositException(String message) {
        super(message);
    }
}

// Custom exception for insufficient funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
