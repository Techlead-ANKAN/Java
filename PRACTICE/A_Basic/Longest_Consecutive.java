import java.util.*;

public class Longest_Consecutive {
    public static void main(String [] args){
        int[] nums = {49, 1, 3, 200, 2, 4};
        int longestSeq = 0;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] + 1 == nums[i+1]){
                longestSeq++;
            }
        }

        System.out.println("Length of Longest Consecutive elements: " + (longestSeq));
    }
}
