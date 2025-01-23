import java.util.*;

public class k_largest{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int nums [] = {27, 56, 19, 01, 278, 76, 54, 89};
        Arrays.sort(nums);

        int k = sc.nextInt();

        System.out.println(k + " largest elements are: " );
        for(int i = nums.length - 1; i >= nums.length - 3; i--){
            System.out.print(nums[i] + " ");
        }
        sc.close();
    }
}