package Lab1_Programming_Revision.Q3;

import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account(){
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
    }

    public Account(int id, double balance){
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

    public boolean withdraw(double amount){
        if (amount < this.balance){
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public static void main(String[] args) {
        Account acc = new Account(1122, 20000);
        acc.setAnnualInterestRate(4.5);
        acc.withdraw(2500);
        acc.deposit(3000);
        System.out.println("Balance: " + acc.getBalance());
        System.out.printf("%s%.2f\n", "Montly Interest: ", acc.getMonthlyInterest());
        System.out.println("Date: " + acc.getDateCreated());
    }
}
