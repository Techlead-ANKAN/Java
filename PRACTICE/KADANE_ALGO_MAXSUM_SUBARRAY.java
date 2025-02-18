package PRACTICE;

public class KADANE_ALGO_MAXSUM_SUBARRAY {

    public static void Kadanes_maxSum(int [] nums){
        int currSum = 0, maxSum = 0;

        for(int i = 1; i < nums.length; i++){
            currSum += nums[i];
            if(currSum < 0){
                currSum = 0;
            }
            if(maxSum < currSum){
                maxSum = currSum;
            }
        }
        System.out.println("MaxSum: "+maxSum);
    }

    public static void main(String [] args){
        int [] a  = {-2, -3, 4, -1, -2, 1, 5, -3};
        Kadanes_maxSum(a);
    }
    
}
