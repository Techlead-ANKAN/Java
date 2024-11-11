//  1) Find the max of three no.s

// import java.util.Scanner;

// class EXAM 
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         int a = sc.nextInt();
//         int b = sc.nextInt();
//         int c = sc.nextInt();

//         if((a>b) && (a>c))
//             System.out.println("A is Max");
//         else if ((b>c) && (b>a))
//             System.out.println("B is Max");
//         else 
//             System.out.println("C is Max");
//     }
// }


// 2) Write a program to reverse the digits in a number.

// import java.util.Scanner;

// class EXAM 
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         int num = sc.nextInt();
//         int temp = num;
//         int rem, sum = 0;

//         while(num>0)
//         {
//             rem = num % 10;
//             sum = (sum *10) + rem;
//             num = num /10;
//         }

//     System.out.println("Reversed Number: "+sum);
//     }
// }


// 3) Write programs in Java to use Wrapper class of each primitive data types.

// class EXAM 
// {
//     public static void main(String[]args)
//     {

//         Integer a = 12;
//         Double b = 25.14;
//         Character c = 'A';

//         System.out.println(a);
//         System.out.println(b);
//         System.out.println(c);
//     }
// }


// 4) Check a number is Palindrom or not (121 = 121)

// class EXAM
// {
//     public static void main(String[]args)
//     {
//         int a = 121;
//         int temp = a, rem, sum = 0;

//         while(a>0)
//         {
//             rem = a % 10;
//             sum = (sum*10) + rem;
//             a = a / 10;
//         }

//         if (sum==temp)
//             System.out.println("Palindrome");
//         else
//             System.out.println("Not Palindrome");
//     }
// }


// 5) Write a program in Java to develop user defined exception for 'Divide by Zero' error.

// class EXAM 
// {
//     public static void main(String[]args)
//     {
//         int  a = 12, b = 0, result;

//         try 
//         {
//             result = a / b;
//             System.out.println(result);
//         }

//         catch (ArithmeticException e)
//         {
//             System.out.println("Can't be divided by zero"+e);
//         }
//     }
// }


// 6) Write a program in Java to demonstrate multiple try block and multiple catch exception

// class EXAM 
// {
//     public static void main(String[]args)
//     {
//         try 
//         {
//             int [] a = new int[10];
//             a[10] = 30/9;        
//         }
//         catch (ArithmeticException e)
//         {
//             System.out.println(e.getMessage());
//         }
//         catch(ArrayIndexOutOfBoundsException e)
//         {
//             System.out.println(e.getMessage());
//         }
//     }
// }


// 7) Write a java program to implement multilevel inheritance.

// class A
// {
//     public void method_A()
//     {
//         System.out.println("This is a method of A");
//     }
// }

// class B extends A
// {
//     public void method_B()
//     {
//         System.out.println("This is a method of B");
//     }
// }

// class EXAM extends B
// {
//     public void method_C()
//     {
//         System.out.println("This is a method of C");
//     }

//     public static void main(String[]args)
//     {
//         EXAM ob = new EXAM();

//         ob.method_A();
//         ob.method_B();
//         ob.method_C();
//     }
// }


// 8) Write a java program to implement hierarchical inheritance.

// class A 
// {
//     public void methodA()
//     {
//     System.out.println("method of Class A");
//     } 
// }
   
// class B extends A 
// {
//     public void methodB()
//     {
//     System.out.println("method of Class B");
//     } 
// }

// class C extends A 
// {
//    public void methodC() 
//    {
//     System.out.println("method of Class C"); 
//    }
// }
   

// class EXAM
// {
//    public static void main(String args[]) 
//    {
//         B obj1 = new B();
//         C obj2 = new C();

//         //All classes can access the method of class A
//         obj1.methodA();
//         obj2.methodA();

//     }
// }


// 9) Write a java program to implement single inheritance.

// class A
// {
//     public void methodA()
//     {
//         System.out.println("Method of A");
//     }
// }

// class B extends A
// {
//     public void methodB()
//     {
//         System.out.println("Method of B");
//     }
// }

// class EXAM
// {
//     public static void main(String[]args)
//     {
//         B ob = new B();
//         ob.methodA();
//         ob.methodB();
//     }
// }


// 10) Leap Year Check

// 11) Write a program in Java to create, write, modify, read operations on a
// Text file.

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

class EXAM
{
    public static void main(String[]args)
    {
        FileWriter fw = new FileWriter("D:Sample.txt");
        fw.write("Fuck you"); 

    }
}