// 6. Constructor with Validation
// Write a Java program to create a class called Account with instance variables accountNumber and balance. Implement a parameterized constructor that initializes these variables with validation:

// accountNumber should be non-null and non-empty.
// balance should be non-negative.
// Print an error message if the validation fails.


package PRACTICE.CONSTRUCTOR;

public class Q6 {
    String accNumber;
    double balance;

    Q6(String accNumber, double balance){
        if(accNumber == null || accNumber.isEmpty()){
            System.out.println("Error: Account Number cannot be null or empty");
        }
        else{
            this.accNumber = accNumber;
        }

        if(balance < 0){
            System.out.println("Error: Account Number cannot be null or empty");
        }
        else{
            this.balance = balance;
        }
    }

    void getDetails(){
        System.out.println("Account Number: " + accNumber);
        System.out.println("Balance: " + balance);
    }

    public static void main(String [] args){
        Q6 account = new Q6("1234567890", 1000.0);
        account.getDetails();
    }
}
