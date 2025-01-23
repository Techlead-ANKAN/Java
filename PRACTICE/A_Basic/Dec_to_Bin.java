import java.util.*;

public class Dec_to_Bin {
    public static void main(String [] args){
        int dec, quot, i=0, j;
        int b[] = new int[100];

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter decimal no: ");
        dec = sc.nextInt();
        quot = dec;

        while(quot != 0){
            b[i] = quot % 2;
            quot = quot / 2;
            i++;
        }

        System.out.println("Binary number: ");
        for(j = i - 1; j >= 0; j--){
            System.out.print(b[j]);
        }

        sc.close();
    }
}
