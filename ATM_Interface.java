// Project 01 ::                                               ATM_INTERFACE
import java.util.Scanner;

public class ATM {
    int withdrawCount = 0;
    int depositCount = 0;
    int transferCount = 0;
    Scanner sc = new Scanner(System.in);
    double balanceAmount = 10000; // initial_amount
    double withdraw;
    double deposit;
    double transferAmount;
    int choice;

    void transaction() {
        if ((withdrawCount == 0 && depositCount == 0) && transferCount == 0) {
            System.out.println("No transactions occurred on your account.");
        } else if (depositCount > 0) {
            System.out.println("Amount deposited by you: " + deposit);
        } else if (withdrawCount > 0) {
            System.out.println("Amount withdrawn by you: " + withdraw);
        } else if (transferCount > 0) {
            System.out.println("Amount transferred by you: " + transferAmount);
        }
    }

    void withdraw() {
        System.out.println("Please enter the amount you want to withdraw: ");
        withdraw = sc.nextDouble();
        if (balanceAmount >= withdraw) {
            System.out.println("Amount withdrawn by you: " + withdraw);
            balanceAmount -= withdraw;
            System.out.println("Your current bank balance: " + balanceAmount);
            withdrawCount++;
        } else {
            System.out.println("You do not have enough money to withdraw.");
        }
    }

    void deposit() {
        System.out.println("Please enter the amount you want to deposit: ");
        deposit = sc.nextDouble();
        balanceAmount += deposit;
        System.out.println("Your bank balance after deposit: " + balanceAmount);
        depositCount++;
    }

    void transfer() {
        System.out.println("Please enter the receiver's account number: ");
        double accountNumber = sc.nextDouble();
        System.out.println("Please enter the amount you want to transfer: ");
        transferAmount = sc.nextDouble();
        if (balanceAmount >= transferAmount) {
            System.out.println("Amount transferred by you: " + transferAmount);
            balanceAmount -= transferAmount;
            System.out.println("Your current bank balance: " + balanceAmount);
        } else {
            System.out.println("You do not have enough money to transfer.");
        }
        transferCount++;
    }

    void quit() {
        System.out.println("Thank you for using our ATM.");
        System.exit(0);
    }

    public static boolean selectingChoice(boolean continueChoice) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to continue (1-Yes, 0-No)?");
        int choices = sc.nextInt();
        if (choices == 0) {
            continueChoice = false;
        } else if (choices == 1) {
            continueChoice = true;
        } else {
            System.out.println("Enter Valid Option");
        }
        return continueChoice;
    }

    public static void main(String[] args) {
        int correctPin = 0000; // initial_pin
        Scanner sc = new Scanner(System.in);
        ATM obj = new ATM();
        System.out.println("WELCOME TO ATM");
        System.out.println("INSERT YOUR CARD");
        System.out.println("PLEASE ENTER YOUR PIN: ");
        int pin = sc.nextInt();
        boolean continueChoice = true;
        if (correctPin == pin) {
            int choice;
            do {
                System.out.println("PRESS 1 FOR LAST TRANSACTION");
                System.out.println("PRESS 2 FOR WITHDRAWAL");
                System.out.println("PRESS 3 FOR DEPOSIT");
                System.out.println("PRESS 4 FOR TRANSFER");
                System.out.println("PRESS 5 TO QUIT");

                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        obj.transaction();
                        continueChoice = selectingChoice(continueChoice);
                        continue;
                    case 2:
                        obj.withdraw();
                        continueChoice = selectingChoice(continueChoice);
                        continue;
                    case 3:
                        obj.deposit();
                        continueChoice = selectingChoice(continueChoice);
                        continue;
                    case 4:
                        obj.transfer();
                        continueChoice = selectingChoice(continueChoice);
                        continue;
                    case 5:
                        obj.quit();
                        continue;
                    default:
                        System.out.println("Please enter a valid option.");
                }
            } while (continueChoice);
        }
    }
}
