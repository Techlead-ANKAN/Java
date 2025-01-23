// Write a Java method to check whether a string is a valid password.

// Password rules:
// A password must have at least ten characters.
// A password consists of only letters and digits.
// A password must contain at least two digits.


import java.util.*;

public class Valid_Password {

    static boolean Password_Checker(String password){

        int numcount = 0;

        if(password.length() < 10){
           return false;
        }

        for(int i=0;i<password.length();i++){
            char ch = password.charAt(i);

            if(Character.isDigit(ch)){
                numcount++;
            }else if(!Character.isLetter(ch)){
                return false;
            }
        }

        if (numcount < 2) {
            return false;
        }

        return true;
    }


    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if(Password_Checker(pass)){
            System.out.println("Valid");
        }
        else{
            System.out.print("Not Valid");
        }
        sc.close();
    }
}
