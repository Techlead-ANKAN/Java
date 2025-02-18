package PRACTICE;

public class SubArrays {
    public static void subArray_maxSum(int [] nums){

        int maxSum = 0;

        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                int sum = 0;
                for(int k = i; k <= j; k++){
                    sum += nums[k];
                }
                System.out.println(sum);
                if(sum > maxSum)
                    maxSum = sum;
            }
        }

        System.out.println("MaxSum = "+maxSum);
    }

    public static void main(String [] args){
        int a[] = {1,-2,6,-1,3};
        subArray_maxSum(a);
    }
}
