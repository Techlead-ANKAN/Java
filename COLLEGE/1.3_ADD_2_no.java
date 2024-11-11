import java.util.Scanner;

class ADD_2_no
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a: ");
        int a = sc.nextInt();
        System.out.println("Enter b: ");
        int b = sc.nextInt();
        int c;
        c = a+b;
        System.out.println("Result: "+c);
        sc.close();
        
    }
}