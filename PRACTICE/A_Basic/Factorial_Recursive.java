import java.util.*;

public class Factorial_Recursive {

    static int findFactorial(int num){
        if (num == 0)
            return 1;
        else{
            return num * findFactorial(num-1);
        }
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a num: ");
        int n = sc.nextInt();
        int res = findFactorial(n);
        System.out.println("Factorial of " + n + " = " + res);
        sc.close();
    }
}
