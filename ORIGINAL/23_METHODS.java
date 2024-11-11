// METHODS - A method is a block of code which only runs when it is called. You can pass data known as parameters into a method. Methods are used to perform certain actions and they are also knwon as functions.

// Syntax - >
// static <return_data_type> <Method_Name>(parameters)
// {
//     code to be executed
// }

// Ex:-
// import java.util.Scanner;
// class METHODS
// {
//     static void  GREET(String name)
//     {
//         System.out.println("Good Morning "+name);
//     }

//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter your name: ");
//         String nm = sc.nextLine();

//         GREET(nm);     // --> Calling the function named "GREET"
//         sc.close();
//     }
// }

// Ex:-

// import java.util.Scanner;
// class METHODS
// {
//     static int  ADD(int x, int y)
//     {
//         int res = x+y;
//         return res;
//     }

//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter 1st no: ");
//         int a = sc.nextInt();
//         System.out.println("Enter 2nd no: ");
//         int b = sc.nextInt();

//         int sum = ADD(a,b);   // --> Calling the function named "ADD"
//         System.out.println("Result = "+sum);
//         sc.close();
//     }
// }

// static keyword - The static keyword in java is used to share the same variabe or method of a given class.

// Return data type - 
// (i) void - when the function returns a value of data type "NULL"
// (ii) int - when the function returns a value of data type "INTEGER"
// (iv) double - when the function returns a value of data type "DOUBLE"
// (iii) float - when the function returns a value of data type "FLOAT"
// (iii) boolean - when the function returns a value of data type "BOOLEAN"


// Calling a function by creating an "object" of the class (No need to declare "static" in this case)

// Synatx for creating class object :-
// <class_name> <object_name> = new <class_name>();


// class METHODS
// {
//     int add(int x, int y)
//     {
//         int z = x+y;
//         return z;
//     }
//     public static void main(String[]args)
//     {
//         METHODS obj = new METHODS();
//         int a = 5, b = 10;
//         System.out.println(obj.add(a,b));
//         System.out.println(obj.add(2,3));
//         System.out.println(obj.add(4,5));
//     }
// }


// METHOD OVERLOADING - When a class has two or more methods of the same name but with different parameters then it is known as Method Overloading

// class METHODS
// {
//     int add(int x, int y)
//     {
//         return (x+y);
//     }

//     double add(double x, double y)
//     {
//         return (x+y);
//     }

//     double add(double x, int y, double z)
//     {
//         return (x+y+z);
//     }

//     public static void main(String[]args)
//     {
//         METHODS obj = new METHODS();
//         System.out.println(obj.add(2,3));
//         System.out.println(obj.add(2.5,3.5));
//         System.out.println(obj.add(2.5,3,4.5));
//     }
// }


// Variable Arguements (Varargs) - A function with varargs can be created in java using the following syntax.

// static <return_type> <function_name> (int ... arr)   // arr is available as :- int [] arr  
// {
//     code to be executed
// }

// Ex:-

// class METHODS
// {
//     static void ADD(int ... arr)
//     {
//         int sum = 0;
//         for (int i: arr)
//         {
//             sum = sum + i;
//         }
//         System.out.println(sum);
//     }
//     public static void main(String[]args)
//     {
//         ADD(1,2,3,4,5,6,7,8,9,10);
//     }
// }


// Recursion - A function can call itself. Such calling of function by itself is called Recursion.

// Ex:- Factorial of a number
//      factorial (n)  =  n * factorial (n-1)


// Ex:-

// class METHODS
// {
//     static int factorial(int x)
//     {
//         if (x==0)
//             return 0;
//         else
//             return (x*factorial(x-1));
//     }

//     public static void main(String[]args)
//     {
//         int fact = factorial(5);
//         System.out.println(fact);
//     }
// }

class example
{
    example(int a, int b)  // First Constructor
    {
        System.out.println(a+b);
    }
    
    example(double a, double b, double c)  // Second Constructor 
    {
        System.out.println(a+b+c);
    }
    
    public static void main(String[]args)
    {
        example ob1 = new example(5,5);   // Calling First Constructor at the time of object creation.
        example ob2 = new example(2.5,3.5,4.0);    // Calling Second Constructor at the time of object creation.
    }
}










