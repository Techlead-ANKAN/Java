// User-Defined Exception - AgeException

// Extending the base Exception Class
class AgeException extends Exception{
    public AgeException(String msg){
        super(msg); // passing the error message to the base exception class
    }
}


public class excep{

    public static void Eligibility(int age) throws AgeException {
        if (age < 18){
            throw new AgeException("Age must be 18 years or older!!!");  // Throwing the exception message
        }
        else{
            System.out.println("Eligible to drive.");
        }
    }

    public static void main(String args[]){
        try{
            int age = 12;
            Eligibility(age);
        }
        catch(AgeException e){
            System.out.println(e);
        }
    }

}

