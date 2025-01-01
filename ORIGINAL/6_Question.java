// Q) Write a program to calculate the percentage of a given student in CBSE board exam. His marks in 5 subjects must be user input.

import java.util.Scanner;

class vi_Question
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Physics's marks: ");
        int m1 = sc.nextInt();

        System.out.print("Enter Math's marks: ");
        int m2 = sc.nextInt();
        
        System.out.print("Enter Chemistry's marks: ");
        int m3 = sc.nextInt();

        System.out.print("Enter Computer's marks: ");
        int m4 = sc.nextInt();

        System.out.print("Enter Biology's marks: ");
        int m5 = sc.nextInt();

        float percent = (m1 + m2 + m3 + m4 + m5)/5;
        System.out.print("Percentage: "+percent);

        sc.close();
    }
}