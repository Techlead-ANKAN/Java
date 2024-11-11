// Constructor - A constructor in java is a special type of method that has the same name as that of the class name, and is called when an object of a class is created.

// These are of two types:-
// i) Default Contsructors - A constructor with no parameters is known as Default Constructor.
// ii) Parameterised Constructor - A constructor with parameters is known as Parameterized Constructor.

// i) Default Constructor

// class CONSTRUCTOR
// {
//     CONSTRUCTOR()
//     {
//         System.out.println("This is a text.");
//     }

//     public static void main(String[]args)
//     {
//         CONSTRUCTOR ob = new CONSTRUCTOR();
//     }
// }

// ii) Parameterized Constructor

// class CONSTRUCTOR
// {
//     CONSTRUCTOR(int a, int b)
//     {
//         System.out.println(a+b);
//     }

//     public static void main(String[]args)
//     {
//         CONSTRUCTOR ob = new CONSTRUCTOR(25, 25);
//     }
// }



// Constructor Overloading - When there are two or more Contsructors with the constructor name same as that of class name but with diffrent parameters.

// Example:-

// class CONSTRUCTOR
// {
//     CONSTRUCTOR (int a, int b)
//     {
//         System.out.println(a+b);
//     }

//     CONSTRUCTOR(double a, double b, double c)
//     {
//         System.out.println(a*b*c);
//     }

//     CONSTRUCTOR (double a, int b, float c)
//     {
//         System.out.println(a+b+c);
//     }

//     public static void main(String[]args)
//     {
//         CONSTRUCTOR obj1 = new CONSTRUCTOR(1,1);
//         CONSTRUCTOR obj2 = new CONSTRUCTOR(1.5,1.5,1.5);
//         CONSTRUCTOR obj3 = new CONSTRUCTOR(1.5,1.5,1.2);
//     }
// }

