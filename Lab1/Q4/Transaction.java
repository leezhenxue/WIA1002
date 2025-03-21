package Q4;

import java.util.Date;

public class Transaction {
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;

    public Transaction(Date date, char type, double balance, String description){
        this.date = date;
        this.type = type;
        this.balance = balance;
        this.description = description;
    }

    @Override
    public String toString(){
        return "Date: " + this.date + "\nType: " + this.type + 
               "\nBalance: " + this.balance + 
               "\nDescription: " + this.description + "\n";
    }
}
