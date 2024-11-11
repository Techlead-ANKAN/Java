import java.util.Scanner;
class MAX_3_NOs
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a: ");
        int a = sc.nextInt();
        System.out.println("Enter b: ");
        int b = sc.nextInt();
        System.out.println("Enter c: ");
        int c = sc.nextInt();

        if(a>b && b>c)
        {
            System.out.println("MAX = A");
        }
        else if (b>c && b>a)
        {
            System.out.println("MAX = B");
        }
        else
        {
            System.out.println("MAX = C");
        }
        sc.close();
    }
}