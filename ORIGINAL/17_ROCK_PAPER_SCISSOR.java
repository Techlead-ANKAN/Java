import java.util.Scanner;
import java.util.Random;

class ROCK_PAPER_SCISSOR
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        int random_no = r.nextInt(2);
        System.out.println("Computer decided it's move: ");
        
        System.out.println("Your Turn: [0 for rock, 1 for paper, 2 for scissor]: ");
        int p = sc.nextInt();

        if (random_no == 0)
        {
            if (p == 0)
                System.out.println("TIE");
            else if (p == 1)
                System.out.println("YOU WIN");
            else
                System.out.println("YOU LOSE");
        }
        else if (random_no == 1)
        {
            if (p == 0)
                System.out.println("YOU LOSE");
            else if (p == 1)
                System.out.println("TIE");
            else
                System.out.println("YOU WIN");
        }
        else
        // if (random_no == 2)
        {
            if (p == 0)
                System.out.println("YOU WIN");
            else if (p == 1)
                System.out.println("YOU LOSE");
            else
                System.out.println("TIE");
        }

        sc.close();
    }
}