import java.util.Scanner;
class NumToWord
{
    public void chk(int n, String ch)
    {
        String one[] = {"", " one"," two"," three"," four"," five"," six"," seven"," eight"," nine"," ten"," eleven"," twelve"," thirteen"," fourteen"," fifteen"," sixteen"," seventeen"," eighteen"," nineteen"};

        String ten[] = {" ",""," twenty"," thirty"," fourty"," fifty"," sixty"," seventy"," eighty"," ninety"};
    if(n>19)
    {
        System.out.print(ten[n/10]+" "+one[n%10]);
    }
    else
    {
        System.out.print(one[n]);
    }

    if(n>0)
    {
        System.out.print(ch);
    }
    }

    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a no: ");
        int n = sc.nextInt();
        if(n<=0)
        {
            System.out.println("Enter numbers greater than 0");
        }
        else
        {
            NumToWord a = new NumToWord();
            a.chk((n/1000000000)," billion");
            a.chk((n/10000000)%100," crore");
            a.chk((n/100000)%100," lakh");
            a.chk((n/1000)%100," thousand");
            a.chk((n/100)%10," hundred");
            a.chk((n%100),"");
        }
        sc.close();
    }
}
