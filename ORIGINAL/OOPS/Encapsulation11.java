// File: Encapsulation11.java
// Topic: Encapsulation (data hiding + getters/setters)

/*
------------------------------------------------------------
📌 WHAT YOU WILL LEARN
------------------------------------------------------------
1. Encapsulation:
   - Keeping fields private.
   - Providing public getters and setters.
2. Advantages:
   - Control access to data.
   - Validation possible in setters.
------------------------------------------------------------
*/

class BankAccount {
    private String holderName;
    private double balance;

    public BankAccount(String holderName, double balance) {
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getter
    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Setter with validation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance");
        }
    }
}

public class Encapsulation11 {

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Ankan", 1000);

        System.out.println("Account Holder: " + acc.getHolderName());
        System.out.println("Balance: " + acc.getBalance());

        acc.deposit(500);
        acc.withdraw(300);

        System.out.println("Final Balance: " + acc.getBalance());
    }
}
