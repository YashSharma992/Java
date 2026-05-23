package experiment10;
//Abstract class representing a Bank Account
abstract class BankAccount {
 private String accountNumber;
 private String accountHolderName;
 private double balance;

 // Constructor
 public BankAccount(String accountNumber, String accountHolderName, double balance) {
     this.accountNumber = accountNumber;
     this.accountHolderName = accountHolderName;
     this.balance = balance;
 }

 // Encapsulation: Getters and Setters
 public String getAccountNumber() {
     return accountNumber;
 }

 public void setAccountNumber(String accountNumber) {
     this.accountNumber = accountNumber;
 }

 public String getAccountHolderName() {
     return accountHolderName;
 }

 public void setAccountHolderName(String accountHolderName) {
     this.accountHolderName = accountHolderName;
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited: " + amount);
     } else {
         System.out.println("Invalid deposit amount!");
     }
 }

 // Protected method to allow subclasses to update balance
 protected void updateBalance(double amount) {
     this.balance = amount;
 }

 // Abstract method (Abstraction)
 public abstract double calculateInterest();

 // Method to display account details
 public void displayDetails() {
     System.out.println("Account Number: " + accountNumber);
     System.out.println("Account Holder Name: " + accountHolderName);
     System.out.println("Balance: " + balance);
 }
}

//SavingsAccount class (Inheritance)
class SavingsAccount extends BankAccount {
 private double interestRate = 0.04; // 4% interest

 public SavingsAccount(String accNo, String name, double balance) {
     super(accNo, name, balance);
 }

 @Override
 public double calculateInterest() {
     return getBalance() * interestRate;
 }
}

//CurrentAccount class (Inheritance)
class CurrentAccount extends BankAccount {
 private double interestRate = 0.02; // 2% interest

 public CurrentAccount(String accNo, String name, double balance) {
     super(accNo, name, balance);
 }

 @Override
 public double calculateInterest() {
     return getBalance() * interestRate;
 }
}

//Main class
public class experiment10 {
 public static void main(String[] args) {
     // Creating objects
     SavingsAccount sa = new SavingsAccount("SA1001", "Yash Sharma", 5000);
     CurrentAccount ca = new CurrentAccount("CA2001", "Amit Verma", 8000);

     // Deposit money
     sa.deposit(2000);
     ca.deposit(3000);

     // Display details
     System.out.println("\n--- Savings Account Details ---");
     sa.displayDetails();
     System.out.println("Interest: " + sa.calculateInterest());

     System.out.println("\n--- Current Account Details ---");
     ca.displayDetails();
     System.out.println("Interest: " + ca.calculateInterest());
 }
}

