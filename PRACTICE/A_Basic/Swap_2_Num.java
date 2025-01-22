// Write a Java program to swap two variables.

import java.util.*;

public class Swap_2_Num {
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int temp;

        temp = a;
        a = b;
        b = temp;
        System.out.println("A = " + a);
        System.out.println("B = " + b);
        sc.close();
    }
}
