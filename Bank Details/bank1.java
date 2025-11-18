import java.util.Scanner;

class Account 
{
    String customerName;
    String accountNumber;
    String accountType;
    double balance;

    Account(String c, String aN, String aT, double b) {
        this.customerName = c;
        this.accountNumber = aN;
        this.accountType = aT;
        this.balance = b;
    }

    void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } 
        else 
        {
            System.out.println("Invalid deposit amount.");
        }
    }


    void displayBalance() {
        System.out.println("Current Balance: Rs. " + balance);
    }
}

class Saving extends Account 
{
    double INTEREST_RATE = 0.05; 

    Saving(String customerName, String accountNumber, double initialBalance) 
    {
        super(customerName, accountNumber, "Savings", initialBalance);
    }

    void computeAndDepositInterest(int years) {
        double interest = balance * Math.pow((1 + INTEREST_RATE), years) - balance;
        balance += interest;
        System.out.println("Interest of Rs. " + String.format("%.2f", interest) + " added to your account.");
    }
    void withdraw(double amount) 
    {
        if (amount <= balance) 
        {
            balance -= amount;
            System.out.println("Withdrawn:" + amount);
        } else 
        {
            System.out.println("Insufficient balance!");
        }
    }
}

class Current extends Account {
    double MIN_BALANCE = 1000.0;
    double SERVICE_CHARGE = 50.0;

    public Current(String customerName, String accountNumber, double initialBalance) 
    {
        super(customerName, accountNumber, "Current", initialBalance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs. " + amount);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            balance -= SERVICE_CHARGE;
            System.out.println("Balance below minimum! Service charge of Rs." + SERVICE_CHARGE + " imposed.");
        }
    }
}

public class bank1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Customer Name:");
        String name = in.nextLine();

        System.out.println("Enter Account Number:");
        String accNo = in.nextLine();

        System.out.println("Enter Account Type (savings/current):");
        String type = in.nextLine().toLowerCase();

        System.out.println("Enter Initial Balance:");
        double balance = in.nextDouble();

        Account account;

        if (type.equals("savings")) 
        {
            account = new Saving(name, accNo, balance);
        }
        else 
        {
            account = new Current(name, accNo, balance);
        }

        int choice;
        do {
            System.out.println("\nOptions Available");
            System.out.println("1. Deposit"); 
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (account instanceof Saving)
                System.out.println("4. Compute and Deposit Interest");
            System.out.println("5 . Exit");
            System.out.print("Enter choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = in.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = in.nextDouble();
                    if(account instanceof Saving) {
                        ((Saving) account).withdraw(withdrawAmount);
                    } else {
                        ((Current) account).withdraw(withdrawAmount);
                    }
                    break;

                case 3:
                    account.displayBalance();
                    break;

                case 4:
                    if (account instanceof Saving) {
                        System.out.print("Enter number of years for interest: ");
                        int years = in.nextInt();
                        ((Saving) account).computeAndDepositInterest(years);
                    } else {
                        System.out.println("Interest computation not available for Current Account.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Program ");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        in.close();
    }
}