import java.util.Scanner;
class AREA_TRIANGLE
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter base: ");
        int base = sc.nextInt();
        System.out.println("Enter height: ");
        int h = sc.nextInt();
        double area = 0.5*base*h;
        System.out.println("Area = "+area);
        sc.close();
    }
}