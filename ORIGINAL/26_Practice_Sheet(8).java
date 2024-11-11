// Practice Set - 8

// public class 26_Practice_Sheet(8) {

// 1) Create a class Employee with the following properties and methods:
// Salary (property) (int)
// getSalary (method returning int)
// name (property) (String)
// getName (method returning String)
// setName (method changing name)

//     class Employee
//     {
//         int salary;
//         String name;

//         public int getSalary()
//         {
//             return(salary);
//         }

//         public String getName()
//         {
//             return(name);
//         }

//         public void setName(String new_name)
//         {
//             name = new_name;
//         }

//         public static void main(String[]args)
//         {
//             Employee EMP1 = new Employee();

//             EMP1.name = "Ankan Maity";
//             EMP1.salary = 250000;

//             System.out.println("Before changing name: ");
//             System.out.println("Name - "+EMP1.getName());
//             System.out.println("Salary - "+EMP1.getSalary()+"\n");

//             EMP1.setName("Piu Maity");

//             System.out.println("\nAfter changing name: ");
//             System.out.println("Name - "+EMP1.getName());
//             System.out.println("Salary - "+EMP1.getSalary());

//         }
// }


// 2) Create a class cellphone with methods to print “ringing…”, “vibrating…”, etc.

// class cellphone
// {
//     public void ring()
//     {
//         System.out.println("Ringing.....");
//     }

//     public void vibrate()
//     {
//         System.out.println("Vibrating.....");
//     }

//     public static void main(String[]args)
//     {
//         cellphone Samsung = new cellphone();
//         Samsung.ring();
//         Samsung.vibrate();
//     }
// }


// 3) Create a class Square with a method to initialize its side, calculating area, perimeter, volume.

// class Square
// {
//     int side;

    // public void cal_area()
    // {
    //     System.out.println("Area of square = "+(side*side));
    // }

    // public void cal_perimeter()
    // {
    //     System.out.println("Perimeter of square = "+(4*side));
    // }

    // public void cal_volume()
    // {
    //     System.out.println("Volume of square = "+(side*side*side));
    // }
     
// }


// 4) Create a class Rectangle & problem 3.

// class rectangle_square
// {
//     int side;
//     int length;
//     int breadth;
//     int height;

//     public void sq_area()
//     {
//         System.out.println("Area of square = "+(side*side));
//     }

//     public void rec_area()
//     {
//         System.out.println("Area of rectangle = "+(length*breadth));
//     }

//     public void sq_perimeter()
//     {
//         System.out.println("Perimeter of square = "+(4*side));
//     }

//     public void rec_perimeter()
//     {
//         System.out.println("Perimeter of rectangle = "+(2*(length+breadth)));
//     }

//     public void sq_volume()
//     {
//         System.out.println("Volume of square = "+(side*side*side));
//     }

//     public void rec_volume()
//     {
//         System.out.println("Volume of rectangle = "+(length*breadth*height));
//     }

//     public static void main(String[]args)
//     {
//         rectangle_square  sq = new rectangle_square();
//         rectangle_square  rec = new rectangle_square();

//         sq.side = 4;

//         rec.length = 2;
//         rec.breadth = 1;
//         rec.height = 1;

//         sq.sq_area();
//         sq.sq_volume();
//         sq.sq_perimeter();

        
//         rec.rec_area();
//         rec.rec_volume();
//         rec.rec_perimeter();
//     }

// }


// 6) Create a class TommyVecetti for Rockstar Games capable of hitting (print hitting…), running, firing, etc.

// class TommyVecetti
// {
//     public void hitting()
//     {
//         System.out.println("Hitting....");
//     }
//     public void running()
//     {
//         System.out.println("Running....");
//     }
//     public void firing()
//     {
//         System.out.println("Firing....");
//     }

//     public static void main(String[]args)
//     {
//         TommyVecetti player = new TommyVecetti();

//         player.hitting();
//         player.running();
//         player.firing();
//     }
// }

// 6) Repeat problem 4 for a circle.

// class circle
// {
//     double radius;

//     public void area()
//     {
//         System.out.println("Area of circle = "+((22/7)*radius*radius));
//     }

//     public void perimeter()
//     {
//         System.out.println("perimeter of circle = "+(2*(22/7)*radius));
//     }

//     public static void main(String[]args)
//     {
//         circle c = new circle();

//         c.radius = 2.5;

//         c.area();
//         c.perimeter();
//     }
// }