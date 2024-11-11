// PRACTICE SHEET - 7

// 1) Write a java method to print multiplication table of a number n.

// import java.util.Scanner;
// class PRACTICE_SHEET
// {
//     static void multiplication_table(int x)
//     {
//         int i;
//         for(i=1;i<=10;i++)
//         {
//             System.out.println(x+" x "+i+" = "+(x*i));
//         }
//     }
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter a number: ");
//         int a = sc.nextInt();
//         multiplication_table(a);
//         sc.close();
//     }
// }


// 2) Using functions print this pattern:-
// *
// * *
// * * * 
// * * * *


// import java.util.Scanner;
// class PRACTICE_SHEET
// {
//     static void Star_pattern(int x)
//     {
//         int i,j;

//         for(i=1;i<=x;i++)
//         {
//             for(j=1;j<=i;j++)
//             {
//                 System.out.print("* ");
//             }
//             System.out.println();
//         }
//     }

//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the no.of rows: ");
//         int r = sc.nextInt();
//         Star_pattern(r);
//         sc.close();
//     }
// }



// 3) Write a reccursive function to find the sum of first n natutral numbers.

// import java.util.Scanner;
// class PRACTICE_SHEET
// {
//     static int SUM(int x)
//     {
//         if (x==0)
//             return 0;
//         else
//             return (x + SUM(x-1));
//     }

//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter no.of natural numbers: ");
//         int n = sc.nextInt();
//         System.out.println(SUM(n));
//         sc.close();
//     }
// }


// 4) Using functions print this pattern:-
// * * * * 
// * * * 
// * * 
// *

import java.util.Scanner;
class PRACTICE_SHEET
{
    static void Star_pattern2(int x)
    {
        int i,j;

        for(i=x;i<=1;i--)
        {
            for(j=1;j<=i;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no.of rows: ");
        int r = sc.nextInt();
        Star_pattern2(r);
        sc.close();
    }
}


// 5) Write a program to print nth term of fibonacci series uaing recursion.

// import java.util.Scanner;
// class PRACTICE_SHEET
// {
//     static int fibonacci(int x)
//     {
//         if (x == 1 || x == 2)
//             return x-1;
//         else    
//             return fibonacci(x-1) + fibonacci(x-2);
//     }

//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the no.of terms: ");
//         int a = sc.nextInt();
//         System.out.println("The "+a+"th term in Fibonacci Series is "+fibonacci(a));
//         sc.close();
//     }
// }



// 6) Write a function to find average of a set of numbers passed as arguements.

// class PRACTICE_SHEET
// {
//     static double Average(int ... ar)
//     {
//         double sum = 0;
//         for (int element: ar)
//         {
//             sum = sum + element;
//         }
//         return(sum/ar.length);
//     }

//     public static void main(String[]args)
//     {
//         System.out.println(Average(1,2,3,4,5,6,7,8,9,10));
//     }
// }


// 9) Write a function to convert celsius temperature to fahrenheit.

// import java.util.Scanner;
// class PRACTICE_SHEET
// {
//     static double temp_convert(double t1)
//     {
//         return ((t1*1.8)+32);
//     }

//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter temperature in celsius: ");
//         double t1 = sc.nextDouble();
//         System.out.println("Fahrenheit: "+temp_convert(t1));
//         sc.close();
//     }
// }

