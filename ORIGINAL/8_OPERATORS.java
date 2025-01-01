// OPERATORS - These are used to perform different operations on values and variables.

import java.util.Scanner;
class OPERATORS
{
  
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        int a,b;
        System.out.print("Enter a: ");
        a = sc.nextInt();
        System.out.print("Enter b: ");
        b = sc.nextInt();

        // ARITHMATIC OPERATORS
        System.out.println("SUM = "+(a+b));           
        System.out.println("SUBTRACT = "+(a-b));      
        System.out.println("PRODUCT = "+(a*b));       
        System.out.println("DIVISION = "+(a/b));      
        System.out.println("REMAINDER = "+(a%b));     

        // ASSIGNMENT OPERATORS
        System.out.println("a = "+ b);
        System.out.println("a += b --> "+(a+=b));   // a = a+b
        System.out.println("a -= b --> "+(a-=b));   // a = a-b
        System.out.println("a *= b --> "+(a*=b));   // a = a*b
        System.out.println("a /= b --> "+(a/=b));   // a = a/b
        System.out.println("a %= b --> "+(a%=b));   // a = a%b

        // RELATIONAL OPERATORS
        System.out.println("a == b --> "+(a==b));
        System.out.println("a != b --> "+(a!=b));
        System.out.println("a > b --> "+(a>b));
        System.out.println("a < b --> "+(a<b));
        System.out.println("a >= b --> "+(a>=b));
        System.out.println("a <= b --> "+(a<=b));

        // LOGICAL OPERATORS
        // 1) &&
        System.out.println((2>1) && (3<13));    // --> True
        System.out.println(2>3);    // --> False

        // 2) ||
        System.out.println((5<3) || (3>1));     // --> True
        System.out.println((5>15) || (3<1));    // --> False

        // 3) !
        System.out.println(!(5 == 3));      // --> True
        System.out.println(! (5 > 3));      // --> False
        
        // UNARY OPERATORS
        int p = 25, q = 50;

        // INCREMENT (++)
        System.out.println("p = "+ p);
        int incre = ++p;   
        System.out.println("++p = "+ incre);

        // DECREMENT (--)
        System.out.println("q = "+ q);
        int decre = --q;
        System.out.println("--q = "+ decre);

        sc.close();

    }
}


/*
 OPERATORS         ------------------------------------>	    PRECEDENCE        -------------------------------------> ASSOCIATIVITY

postfix increment and decrement	                                   ++ --                                                   L to R
prefix increment and decrement, and unary	                    ++ -- + - ~ !                                              R to L
multiplicative	                                                   * / %                                                   L to R
additive	                                                        + -                                                    L to R
shift	                                                         << >> >>>                                                 L to R
relational	                                                < > <= >= instanceof                                           L to R
equality	                                                        == !=                                                  L to R
bitwise                                                             AND	&                                                  L to R
bitwise exclusive OR	                                              ^                                                    L to R
bitwise inclusive OR	                                              |                                                    L to R                     
logical AND	                                                          &&                                                   L to R         
logical OR	                                                          ||                                                   L to R
ternary	                                                              ? :                                                  R to L
assignment	                                            = += -= *= /= %= &= ^= |= <<= >>= >>>=                             R to L
*/