package PRACTICE;

public class SubArrays {
    public static void subArray(int [] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                for(int k = i; k <= j; k++){
                    System.out.print(nums[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String [] args){
        int a[] = {1,2,3,4,5,6,7,8,9,0};
        subArray(a);
    }
}
