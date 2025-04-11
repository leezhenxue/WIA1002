package Q4;

import java.util.ArrayList;
import java.util.Date;

public class Account1 {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    private String name;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account1(){
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
    }

    public Account1(String name, int id, double balance){
        this.name = name;
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
    }

    public int getId(){
        return this.id;
    }

    public double getBalance(){
        return this.balance;
    }

    public double getAnnualInterestRate(){
        return this.annualInterestRate;
    }
    
    public String getName(){
        return this.name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated(){
        return this.dateCreated;
    }
    
    public double getMonthlyInterestRate(){
        return annualInterestRate / 12.0;
    }

    public double getMonthlyInterest(){
        return this.getMonthlyInterestRate() / 100 * this.balance;
    }

    public boolean withdraw(double amount, String description){
        if (amount < this.balance){
            this.balance -= amount;
            Transaction withdrawTransaction = new Transaction(new Date(), 'W', this.balance, description);
            this.transactions.add(withdrawTransaction);
            return true;
        }
        System.out.println("The balance is insufficient");
        return false;
    }

    public void deposit(double amount, String description){
        this.balance += amount;
        Transaction depositTransaction = new Transaction(new Date(), 'D', this.balance, description);
        this.transactions.add(depositTransaction);
    }

    public static void main(String[] args) {
        Account1 acc = new Account1("George", 1122, 1000);
        acc.setAnnualInterestRate(1.5);
        acc.deposit(30, "This is first deposit");
        acc.deposit(40, "This is second deposit");
        acc.deposit(50, "This is third deposit");
        acc.withdraw(5, "This is first withdraw");
        acc.withdraw(4, "This is second withdraw");
        acc.withdraw(2, "This is third withdraw");
        System.out.println("Name: " + acc.getName());
        System.out.printf("%s%.2f%%\n", "Annual Interest Rate: ", acc.getAnnualInterestRate());
        System.out.println("Balance: " + acc.getBalance() + "\n");
        for (Transaction transaction : acc.transactions){
            System.out.println(transaction);
        }
    }
}
