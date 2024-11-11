// 1.Find maximum of three numbers.

// class VIVA
// {
//     public static void main(String[]args)
//     {
//         int a = 1, b = 2, c = 3;

//         if ((a>b) && (a>c))
//             System.out.println("Max - A");
//         else if ((b>a) && (b>c))
//             System.out.println("Max - B");
//         else
//             System.out.println("Max - C");
//     }
// }


// 2.Write a java program to implement multilevel inheritance.

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

// class VIVA extends B
// {
//     public void method_C()
//     {
//         System.out.println("This is a method of C");
//     }

//     public static void main(String[]args)
//     {
//         VIVA ob = new VIVA();

//         ob.method_A();
//         ob.method_B();
//         ob.method_C();
//     }
// }


// 3.Write a java program to implement hierarchical inheritance.

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
   

// class VIVA
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


// 4.Write a java program to implement single inheritance.

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

// class VIVA
// {
//     public static void main(String[]args)
//     {
//         B ob = new B();
//         ob.methodA();
//         ob.methodB();
//     }
// }

// 5.Reverse the digits of a number. 
// 6.Write a program in Java to develop user defined exception for 'Divide
// by Zero' error.
// 7.first n prime numbers
// 8.Matrix multiplication.
// 9.Create a class to find out whether the given year is leap year or not, using inheritance.
// 10.Write a program in Java to demonstrate use of final keyword.
// 11.Write a program in Java to develop overloaded constructor.
