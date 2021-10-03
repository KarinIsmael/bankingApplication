package bank;

import java.util.Scanner;

public class Account {
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    public Account(String name, String id) {
        customerName=name;
        customerID=id;
    }

    void deposit(int amount){
        if(amount !=0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw (int amount){ //should limit this method to not make withdrawal if not enough balance
        if(amount !=0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction >0){
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction<0){
            System.out.println("Withdrew: " + previousTransaction);
        } else {
            System.out.println("No transaction made");
        }
    }

    void calculateInterest(int years){
        double interestRate = .0200;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("Your interest rate is " + (100*interestRate) +"%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    void showMenu() {

        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F Exit");

        do{
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);

            switch (option){
                case 'A':
                    System.out.println("==============================");
                    System.out.println("Balance = " + balance);
                    System.out.println("==============================");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("Enter amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("Enter amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("==============================");
                    getPreviousTransaction();
                    System.out.println("==============================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("Enter how many years of estimated interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                case 'F':
                    System.out.println("==============================");
                    break;
                default:
                    System.out.println("Error: invalid option. Please enter a letter from A-F");
                    break;
            }
        } while (option !='F');
        System.out.println("Thank you for today!");
    }
}
