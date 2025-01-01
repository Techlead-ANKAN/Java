// Strings - These are a sequence of characters in JAVA programming language.

import java.util.Scanner;
class x_STRINGS
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);

        // Initiating a String (1)
        String name = "ANKAN MAITY";
        System.out.println(name);

        // Initiating a String (2)
        String languages = "PYTHON, JAVA, C";
        System.out.println(languages);


        // User Input String

        System.out.print("Enter college name: ");

        // 1) next() -> reads only the first word.
        String college = sc.next();
        System.out.println(college);

        System.out.print("Enter a string: ");

        // 2) nextLine() -> reads the whole string.
        String str = sc.nextLine();
        System.out.println(str);

        sc.close();
    }
}