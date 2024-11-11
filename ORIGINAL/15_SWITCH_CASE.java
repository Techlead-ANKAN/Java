// Switch Case - Switch Case statement is used when we have to make a choice between no.of alternatives for qa given variable.

// Syntax: 

// Switch (var)
// {
//     case c1:
//     code
//     break;

//     case c2:
//     code
//     break;
//     :
//     :
//     :
//     :
//     :
//     default:
//     code
// }


// Example: 

// 1) Write a code to make a calculator which will take operation code from the user.
import java.util.Scanner;
class SWITCH_CASE
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Operation Code[1-Add; 2-Subtract; 3-Product; 4-Divide; 5-Remainder]: ");
        int op = sc.nextInt();
        System.out.println("Enter a: ");
        int a = sc.nextInt();
        System.out.println("Enter b: ");
        int b = sc.nextInt();

        switch (op)
        {
            case (1):
            System.out.println("Addition = "+(a+b));
            break;

            case (2):
            System.out.println("Subtraction = "+(a-b));
            break;

            case (3):
            System.out.println("Product = "+(a*b));
            break;

            case (4):
            System.out.println("Divide = "+(a/b));
            break;

            case (5):
            System.out.println("Reaminder = "+(a%b));
            break;

            default:
            System.out.println("Invalid Input");
        }
        sc.close();
    }
}