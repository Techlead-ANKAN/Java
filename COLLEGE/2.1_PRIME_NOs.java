// import java.util.Scanner;
// class PRIME_NOs
// {
//     public static void main(String[]args)
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter no.of terms: ");
//         int n = sc.nextInt();
//         int i,j;
//         int flag = 0;
//         System.out.println("Prime no.s: ");
        
//         for (i=1;i<=n;i++)
//         {
//             for(j=2;j<i-1;j++)
//             {
//                 if(i%j==0)
//                 {
//                     flag = flag + 1;
//                 }
//             }
//                 if(flag==0)
//                 {
//                     System.out.println(i);
//                 }
//                 else
//                 {
//                     flag=0;
//                 }
//             }
//         }
//     }

// MINE Concept
import java.util.Scanner;
class Prime_no_s
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter lower bound: ");
        int low = sc.nextInt();
        System.out.print("Enter upper bound: ");
        int up = sc.nextInt();
        System.out.println("\n");
        int i,j,flag;
        
        for (i=low;i<=up;i++)
        {
            if(i==1 || i==0)
                continue;
            
            flag = 1;
                
            for(j=2;j<i;j++)
            {
                if (i%j==0)
                {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
                System.out.println(i);
        }
    }
}

