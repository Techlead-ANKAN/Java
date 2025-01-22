import java.util.*;

public class Penultimate_Word{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a string: ");
        String str = sc.nextLine();

        String [] words = str.split(" ");

        
        System.out.println("Penultimate Word: " + words[words.length - 2]);
        
        
        sc.close();
    }
}