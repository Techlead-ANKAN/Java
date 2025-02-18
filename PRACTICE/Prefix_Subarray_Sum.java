package PRACTICE;

public class Prefix_Subarray_Sum {
    public static void prefix_sumSubArray(int [] nums){
        int [] prefix = new int[nums.length];

        int currSum = 0;
        prefix[0] = nums[0];
        for(int i = 1; i < prefix.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        int maxSum = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                for(int k = i; k <= j; k++){
                    currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];
                    if(maxSum < currSum){
                        maxSum = currSum;
                    }
                }
            }
        }
        System.out.println(maxSum);
    }

    public static void main(String [] args){
        int a[]  = {1,-2,6,-1,3};
        prefix_sumSubArray(a);
    }
}

