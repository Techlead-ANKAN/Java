import java.util.*;

public class Addition_Binary{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        int rem = 0, i = 0;
        int [] sum = new int [20];

        System.out.print("Input first binary number: ");
        long b1 = sc.nextLong();

        System.out.print("Input second binary number: ");
        long b2 = sc.nextLong();

        while(b1 != 0 || b2 != 0){
            sum[i] = (int)((b1 % 10 + b2 % 10 + rem) % 2);
            rem = (int)((b1 % 10 + b2 % 10 + rem) / 2);
            b1 = b1 / 10;
            b2 = b2 / 10;
            i++;
        }

        if(rem != 0){
            sum[i] = rem;
            i++;
        }

        --i;

        System.out.print("Sum of 2 binary numbers: ");
        while(i >= 0){
            System.out.print(sum[i]);
            i--;
        }

        sc.close();
    }
}