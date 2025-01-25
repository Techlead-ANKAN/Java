import java.util.*;

public class Fibonacci_Recursive {
    
    static int fibonacciGenerator(int n){
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else{
            return fibonacciGenerator(n - 1) + fibonacciGenerator(n - 2);
        }
    }
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        int res;

        for(int i = 0; i <= n; i++){
            res = fibonacciGenerator(i);
            System.out.print(res + " ");
        }
        sc.close();
    }
}
