import java.util.Scanner;

// Bank account class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public double getBalance() {
        return balance;
    }
}

// ATM class
class ATM {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        int choice;
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    account.withdraw(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    account.deposit(sc.nextDouble());
                    break;
                case 3:
                    System.out.println("Current balance: ₹" + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using ATM!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while(choice != 4);
    }
}

// Main class — must match file name
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);
        ATM atm = new ATM(account);
        atm.start();
    }
}
