import java.util.*;

public class Large_Small_Diff {
    public static void main(String [] args){
        int arr [] = {12, 34, 56, 2, 7, 01, 9, 90, 83};
        Arrays.sort(arr);
        
        if(arr.length > 1){
            System.out.println("Diff b/w largest and smallest: " + (arr[arr.length-1] - arr[0]));
        }

        
    }    
}
