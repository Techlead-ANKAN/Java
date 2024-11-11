/* JAVA [chapter - 1] */

//  VARIABLES - These are the containers where we can store values taht can be changed anytime. 
// Example -> int a = 10; 

//  Rules:- 
//  1) Cannot start with a digit
//  2) Cannot contain space in the variable name
//  3) These are case-sensitive
//  4) Cannout use any keyword as variables
//  5) Can contain alphabets, special characters($ and _) and digits if other conditions are met


class i_VARIABLES
{
    public static void main(String [] args)
    {
        /*VALID*/
        int year = 2022;
        int age123 = 19;
        char Alpha = 'A';
        char vari_able = 'a';
        int dol$lar = 55;

        System.out.println("Year = "+ year);
        System.out.println("Age123 = "+age123);
        System.out.println("Alpha = "+Alpha);
        System.out.println("Vari_able = "+vari_able);
        System.out.println("dol$lar = "+dol$lar);

        
        /*NOT VALID*/
        //  int 123age = 19;
        //  char my name = 'A';
        //  int void = 0;
        //  int s%#ig@*ns = 1;
    }
}
