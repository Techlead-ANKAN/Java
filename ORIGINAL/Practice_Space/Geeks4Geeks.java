package Practice_Space;

// GEEKS 4 GEEKS   [  Link : https://www.geeksforgeeks.org/java-programming-examples/#string]

// [A] Basic Programs
// 1) Java Program to Read The Number From Standard Input

// import java.util.Scanner;
// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter a number: ");
//         int a = sc.nextInt();
//         System.out.println("The number you entered: "+a);
//         sc.close();
//     }
// }

// 2) Java Program to Get Input from the User

// import java.util.Scanner;
// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter a number: ");
//         int a = sc.nextInt();
//         System.out.println("The number you entered: "+a);
//         sc.close();
//     }
// }


// 3) Java Program to Multiply Two Floating-Point Numbers

// import java.util.Scanner;
// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter 1st floating point no: ");
//         float a = sc.nextFloat();

//         System.out.println("Enter 2nd floating point no: ");
//         float b = sc.nextFloat();

//         System.out.println("Result: "+(a*b));
//         sc.close();
//     }
// }


// 4) Java Program to Swap Two Numbers

// import java.util.Scanner;

// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         int  c;
//         System.out.println("Enter a: ");
//         int a = sc.nextInt();

//         System.out.println("Enter b: ");
//         int b = sc.nextInt();

//         c = a;
//         a = b;
//         b = c;

//         System.out.println("Now, a = "+a);
//         System.out.println("Now, b = "+b);
//         sc.close();
//     }
// }


// 5) Java Program to Add Two Binary Strings


// 6) Java Program to Add Two Complex numbers


// 7) Java Program to Check Even or Odd Integers

// import java.util.Scanner;
// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter an integer: ");
//         int a = sc.nextInt();

//         if (a%2==0)
//             System.out.println(a+" is an Even Number");
//         else
//             System.out.println(a+" is an Odd Number");

//             sc.close();
//     }
// }


// 8) Java Program to Find Largest Among 3 Numbers


// import java.util.Scanner;

// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
        
//         System.out.println("Enter a: ");
//         int a = sc.nextInt();

//         System.out.println("Enter b: ");
//         int b = sc.nextInt();

//         System.out.println("Enter c: ");
//         int c = sc.nextInt();

//         if((a>b) && (a>c))
//             System.out.println(a+" is Largest");
//         else if((b>a) && (b>c))
//             System.out.println(b+" is Largest");
//         else
//             System.out.println(c+" is Largest");
//         sc.close();
//     }
// }


// 9) Java Program to Find LCM of 2 numbers

// import java.util.Scanner;

// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter 1st no: ");
//         int a = sc.nextInt();

//         System.out.println("Enter 2nd no: ");
//         int b = sc.nextInt();

//         int lcm, gcd=1, i;

//         for(i=1;i<=a && i<=b;i++)
//         {
//             if((a%i==0) && (b%i==0))
//                 gcd = i;
//         }

//         lcm = (a*b)/gcd;
//         System.out.println("Lcm of "+a+" and "+b+" = "+lcm);
//         sc.close();
//     }
// }


// 10) Java Program to Find GCD or HCF of 2 numbers

// import java.util.Scanner;

// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter 1st no: ");
//         int a = sc.nextInt();

//         System.out.println("Enter 2nd no: ");
//         int b = sc.nextInt();

//         int gcd=1, i;

//         for(i=1;i<=a && i<=b;i++)
//         {
//             if((a%i==0) && (b%i==0))
//                 gcd = i;
//         }
//         System.out.println("Gcd of "+a+" and "+b+" = "+gcd);
//         sc.close();
//     }
// }
// 11) Java Program to Display All Prime Numbers from 1 to N

// import java.util.Scanner;

// class Geeks4Geeks
// {
//     static boolean isPrime(int n)
//     {
//         int i,flag = 0;
//             for(i=2;i<n;i++)
//             {
//                 if(n%i!=0)
//                 {
//                     flag = 1;
//                     break;
//                 }
//             }

//         if(flag==1)
//             return true;
//         else
//             return false;
//     } 
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter the no.of terms: ");
//         int n = sc.nextInt();

//         int i;

//         System.out.println("Prime no.s: ");
//         for(i=1;i<=n;i++)
//         {
//             if(isPrime(i)==true)
//                 System.out.println(i);
//         }
//         sc.close();
//     }
// }


// 12) Java Program to Check Leap Year

// import java.util.Scanner;

// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter a year: ");
//         int yr = sc.nextInt();

//         if(yr%400==0)
//             System.out.println("It is a Leap Year");
//         else if (yr%4==0)
//             System.out.println("It is a Leap year");
//         else if (yr%100==0)
//             System.out.println("It is not a Leap Year");
//         else
//             System.out.println("It is not a Leap Year");
//     }
// }


// 13) Java Program to Check Armstrong Number 

// import java.util.Scanner;

// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter the number: ");
//         int n = sc.nextInt();
//         int rem, sum = 0;
//         int temp = n;
//         while (n>0)
//         {
//             rem = n%10;
//             sum = (sum) + (rem*rem*rem);
//             n = n/10;
//         }
//         if(sum==temp)
//             System.out.println(temp+" is an Armstrong Number");
//         else
//         System.out.println(temp+" is not an Armstrong Number");

//     }
// }


// 14) Java Program to Check whether the input number is a Neon Number

// import java.util.Scanner;

// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter a number: ");
//         int n = sc.nextInt();
//         int mul = n*n;
//         int rem,sum = 0;

//         while (mul>0)
//         {
//             rem = mul%10;
//             sum = sum + rem;
//             mul = mul / 10;
//         }
//         if (sum == n)
//             System.out.println(n+" is a Neon Number");
//         else
//             System.out.println(n+" is not a Neon Number");

//     }
// }
// 15) Java Program to Check whether input character is vowel or consonant

// import java.util.Scanner;

// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter a character: ");
//         String ch = sc.next();
//         String vowel = "aeiouAEIOU";
        
//         if(vowel.contains(ch)==true)
//             System.out.println("It is a Vowel");
//         else
//             System.out.println("It is a Consonant");
    

//     }
// }


// 16) Java Program to Find Factorial of a number

// import java.util.Scanner;

// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter a number: ");
//         int num = sc.nextInt();
//         int i, mul = 1;

//         for(i=1;i<=num;i++)
//         {
//             mul = mul * i;
//         }   

//         System.out.println("Factorial of "+num+" = "+mul);
//     }
// }


// 17) Java Program to Find Even Sum of Fibonacci Series Till number N

// import java.util.Scanner;

// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter the no.of terms: ");
//         int n = sc.nextInt();

        
//     } 
// }


// 18) Java Program to Calculate Simple Interest

// import java.util.Scanner;

// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter Principal Amount: ");
//         double P = sc.nextDouble();

//         System.out.println("Enter Time Period: ");
//         int T = sc.nextInt();

//         System.out.println("Enter Rate of Interest: ");
//         double R = sc.nextDouble();

//         double SI = (P*R*T)/100;
//         System.out.println("Simple Interest: "+SI);
//     }
// }


// 18) Java Program to Calculate Compound Interest

// import java.lang.Math;
// import java.util.Scanner;

// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter Principal: ");
//         double P = sc.nextDouble();

//         System.out.println("Enter Rate of Interest: ");
//         double R = sc.nextDouble();

//         System.out.println("Enter Time Period: ");
//         int T = sc.nextInt();

//         double CI = P*(1+((R/2)/100)) ;
//         double res1 = Math.pow(CI, (2*T));

//         System.out.println("Compund Interest: "+res1);
//     }
// }


// 19) Java Program to Find the Perimeter of a Rectangle

// import java.util.Scanner;

// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter length: ");
//         int L = sc.nextInt();

//         System.out.println("Enter breadth: ");
//         int B = sc.nextInt();

//         double perimeter = 2*(L+B);
//         System.out.println("Perimeter of Rectangle: "+perimeter);
//     }
// }




// [B] String Programs

// 1) Java Program to Get a Character From the Given String

// import java.util.Scanner;
// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter a string: ");
//         String s = sc.nextLine();

//         System.out.println("Enter the index: ");
//         int i = sc.nextInt();
//         int j;
//         for(j=0;j<s.length();j++)
//         {
//             if (j==i)
//             System.out.println("Character at index "+i+" is "+s.charAt(i));
//         }
//     }
// }


// 2) Java Program to Replace a Character at a Specific Index

// import java.util.Scanner;

// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter a string: ");
//         String s = sc.nextLine();

//         char NEW = '#';

//         System.out.println("Enter the index: ");
//         int i = sc.nextInt();
//         int j;
//         String res = " ";
//         for(j=0;j<s.length();j++)
//         {
//             if(j==i)
//             {
//                 res = s.replace(s.charAt(i),NEW);
//                 break;
//             }
//         }
//         System.out.println("New String: "+res);
//     }
// }


// 3) Java Program to Reverse a String

// import java.util.Scanner;

// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter a string:" );
//         String s = sc.nextLine();
//         String rev = " ";
//         int i;

//         for(i=(s.length()-1);i>=0;i--)
//         {
//             rev = rev + s.charAt(i);
//         }

//         System.out.println("Reversed String: "+rev);

//     }
// }


// 4) Java Program to Reverse a String Using Stacks
// 5) Java Program to Sort a String

// 6) Java Program to Swapping Pair of Characters

// import java.util.Scanner;

// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter a string: ");
//         String s = sc.nextLine();
//         // String temp = s;

//         System.out.println("Enter the indexes: ");
//         int n1 = sc.nextInt();
//         int n2 = sc.nextInt();

//         // String first = "";
        // String sec = "";

//         char a;
//         char b;
//         char c;

//         String res = "";
//         int i;

//         for(i=0;i<s.length();i++)
//         {
//             if(i==n1)
//             {
//                 // first = first + s.charAt(i);
//                 // sec = sec + s.charAt(i+1);
//                 // res = res + s.charAt(i+1);
//                 // res = res + s.charAt(i);
//                 a = s.charAt(i);
//                 b = s.charAt(i+1);
//                 c = a;
//                 a = b;
//                 b = c;
//                 res = res + s.charAt(i);
//             }

//         }
//         System.out.println("Result: "+res);

//     }
// }


// 7) Java Program to Check Whether the Given String is Pangram

// import java.util.Scanner;
// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter a string: ");
//         String s = sc.nextLine();
//         int L = s.length();
//         int flag = 0;
//         int i;
//         if(L == 26)
//         {
//             for(i=0;i<L;)
//             {
//                 if(s.charAt(i)!=s.charAt(i+1))
//                     flag = 1;
//                     break;
//             }
//         }
//         if (flag == 1)
//             System.out.println("Pangram String");
//         else
//             System.out.println("Not a Pangram String");
//     }
// }


// 8) Java Program to Print first letter of each word 

// import java.util.Scanner;

// class Geeks4Geeks
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter a string: ");
//         String s = sc.nextLine();
//         int L = s.length();
//         String res = "";
//         String Final;
//         int i;
//         for(i=0;i<L;i++)
//         {
//             if(s.charAt(i)==' ')
//             {
//                 res = res + s.charAt(i+1);
//             }
//         }
//         Final = s.charAt(0) + res;
//         System.out.println("Short Form: "+Final);
//     }
// }


// 9) Java Program to Determine the Unicode Code Point at a given index


// 10) Java Program to Remove leading zeros


// 11) Java Program to Compare two strings
// Java Program to Compare two strings lexicographically
// Java Program to Print even length words
// Java Program to Insert a string into another string
// Java Program to Splitting into a number of sub-strings