package PRACTICE;

public class Trapped_Rainwater {
    public  static void cal_trappedRainwater(int [] bar_heights, int width){
        // max@left boundary
        int [] max_left = new int[bar_heights.length];
        max_left[0] = bar_heights[0];
        for(int i = 1; i < bar_heights.length; i++){
            max_left[i] = Math.max(bar_heights[i], max_left[i-1]);
        }

        // max@right boundary
        int [] max_right = new int[bar_heights.length];
        max_right[bar_heights.length-1] = bar_heights[bar_heights.length-1];
        for(int i = bar_heights.length-2; i >= 0; i--){
            max_right[i] = Math.max(bar_heights[i], max_right[i+1]);
        }

        int trapped_water = 0;
        for(int i = 0; i < bar_heights.length; i++){
            trapped_water += ((Math.min(max_left[i], max_right[i])) - bar_heights[i]) * width;
        }

        System.out.println("Total Trapped Water = " + trapped_water);
    }

    public static void main(String [] args){
        int heights[] = {4,2,0,6,3,2,5};
        int width = 1;
        cal_trappedRainwater(heights, width);
    }
}
