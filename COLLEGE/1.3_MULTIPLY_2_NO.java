import java.util.Scanner;
class MULTIPLY_2_NO
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        int c = a*b;
        System.out.println("Result: "+c);
        sc.close();
    }
}