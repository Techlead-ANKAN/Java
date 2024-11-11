// Practice Sheet - 04

// 1) Find the output of this code:
// int a = 10;
// if (a=11)
//     System.out.println("I am 11");
// else
//     System.out.println("I am not 11");

// --> I am not 11


// 2) Write a code to find out if a student is pass or fail, if it requires total 40% and atleast 33% in each subject to pass. Assume 3 subjects and take marks from the user.

// import java.util.Scanner;
// class Practic_Sheet
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter marks in  Physics: ");
//         int p = sc.nextInt();
//         System.out.println("Enter marks in Chemistry: ");
//         int c = sc.nextInt();
//         System.out.println("Enter marks in Maths: ");
//         int m = sc.nextInt();

//         int total_p = ((p+c+m)/3);

//         if (  p>=33 && c>=33 && m>=33 && total_p>=40  )
//         {
//             System.out.println("PASS");
//         }
//         else
//         {
//             System.out.println("FAIL");
//         }
//         sc.close();
//     }
// }


// 3) Calculate the income tax paid by an employee to the government as per the slabs mentioned below:
// Income slab            Tax
// 2.5 L  - 5 L           5%
// 5 L  -  10 L           20%
// Above 10 L             30%
// Note that there is no tax below 2.5L. (Take user input)

// import java.util.Scanner;

// class Practic_Sheet
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter your income(in LPA): ");
//         double inc = sc.nextDouble();
//         double tax;

//         if ( inc>=2.5 && inc<=5.0)
//         {
//             tax = (inc*100000)*(0.05);
//             System.out.println("Your Income Tax: "+tax);
//         }
//         else if ( inc>=5.0 && inc<=10.0)
//         {
//             tax = (inc*100000)*(0.2);
//             System.out.println("Your Income Tax: "+tax);
//         }
//         else if (inc > 10.0)
//         {
//             tax = (inc*100000)*(0.3);
//             System.out.println("Your Income Tax: "+tax);
//         }
//         else
//         {
//             System.out.println("Invalid Input!!!");
//         }
//         sc.close();
//     }
// }

// 4) Write a code in java to find the day in the week.(Given - 1 for Mondays, 2 for Tuesdays, ......)

// import java.util.Scanner;

// class Practic_Sheet
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the day no.: ");
//         int day = sc.nextInt();

//         switch (day)
//         {
//         case (1):
//         System.out.println("MONDAY");
//         break;

//         case (2):
//         System.out.println("TUESDAY");
//         break;

//         case (3):
//         System.out.println("WEDNESDAY");
//         break;

//         case (4):
//         System.out.println("THURSDAY");
//         break;

//         case (5):
//         System.out.println("FRIDAY");

//         case (6):
//         System.out.println("SATURDAY");
//         break;

//         case (7):
//         System.out.println("SUNDAY");
//         break;

//         default:
//         System.out.println("Invalid Input!!");
//         }
//         sc.close();
//     }
// }


// 5) Write a code in java to check if the year is a laep year or not.

// import java.util.Scanner;
// class Practic_Sheet
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter Year: ");
//         int yr = sc.nextInt();

//         if (yr % 100 == 0)
//         {
//             System.out.println("Leap Year");
//         }
//         else if ( yr % 4 == 0)
//         {
//             System.out.println("Leap Year");
//         }
//         else 
//         {
//             System.out.println("Not Leap Year");
//         }
//         sc.close();
//     }
// }


// 6) Write a code in java to find out what type of website from the url(Take User Input).

// import java.util.Scanner;
// class Practice_Sheet
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter website url: ");
//         String url = sc.nextLine();
// 
//         if (url.contains(".com"))
//         {
//             System.out.println("Commercial Website");
//         }
//         else if (url.contains(".org"))
//         {
//             System.out.println("Organization Website");
//         }
//         else if (url.contains(".in"))
//         {
//             System.out.println("Indian Website");
//         }
//         sc.close();
//     }
// }

