// PRACTICE SHEET - 05

// 1) Write a program to print the following pattern :

// ****

// ***

// **

// *

// import java.util.Scanner;
// class Practice_Sheet
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter no.of rows: ");
//         int n = sc.nextInt();
//         int i,j;

//         for(i=n;i>0;i--)
//         {
//             for(j=0;j<i;j++)
//             {
//                 System.out.print('*');
//             }
//             System.out.println('\n');
//         }
//     }
// }



// 2) Write a program to sum first n even numbers using a while loop.

// import java.util.Scanner;
// class Practice_Sheet
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter no.of terms: ");
//         int n = sc.nextInt();
//         int i = 1;
//         int sum = 0;
//         while(i<n)
//         {
//             if(i%2==0)
//               sum = sum + i;  
//             i++;
//         }
//         System.out.println(sum);
//         sc.close();
//     }
// }



// 3) Write a program to print the multiplication table of a given number n.

// import java.util.Scanner;
// class Practice_Sheet
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the no: ");
//         int n = sc.nextInt();
//         int i;

//         System.out.println("Multiplication Table of "+n+": ");
//         for(i=1;i<=10;i++)
//         {
//             System.out.println(n+ " X " +i+ " = " +(n*i));
//         }
//         sc.close();
//     }
// }


// 4) Write a program to print a multiplication table of 10 in reverse order.

// class Practice_Sheet
// {
//     public static void main(String[]args)
//     {
//         int n = 10;
//         int i;
//         System.out.println("Multiplication Table of 10 in Reverse: ");
//         for(i=10;i>=1;i--)
//         {
//             System.out.println(n+ " X " +i+ " = " +(n*i));
//         }
//     }
// }



// 5) Write a program to find the factorial of a given number using for loops.1st

// import java.util.Scanner;
// class Practice_Sheet
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter no:  ");
//         int n = sc.nextInt();
//         int i, mul = 1;

//         for(i=1;i<=n;i++)
//         {
//             mul = mul * i;
//         }
//         System.out.println("Factorial of "+n+" = "+mul);
//     }
// }



// 6) Write a program to find the factorial of a given number using while loop.

// import java.util.Scanner;
// class Practice_Sheet
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner (System.in);
//         System.out.println("Enter no: ");
//         int n = sc.nextInt();
//         int i = 1, mul = 1;

//         while (i<=n)
//         {
//             mul = mul * i;
//             i++;
//         }
//         System.out.println("Factorial of "+n+" = "+mul);
//         sc.close();
//     }
// }



// 7) Write a program to calculate the sum of the numbers occurring in the multiplication table of 8.

// class Practice_Sheet
// {
//     public static void main(String[]args)
//     {
//         int n = 8;
//         int sum = 0;

//         for(int i=1;i<=10;i++)
//         {
//             sum = sum + (n*i);
//         }
//         System.out.println("Sum = "+ sum);
//     }
// }

