package exercises.leetcode.sliding_windows;

import java.util.HashMap;

public class MaximumAverageSubArray {

    public static void main(String[] args) {

        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(new MaximumAverageSubArray().findMaxAverage(nums, k));
    }


    public double findMaxAverage(int[] nums, int k) {

        double maxAve;

        int sum = 0;
        for (int x = 0; x<k; x++){
            sum+=nums[x];
        }
        maxAve = (double) sum /k;


        int right = k;
        while (right<nums.length){
            sum+=nums[right];
            sum-=nums[right-k];
            maxAve = Math.max((double) sum /k, maxAve);
            right++;

        }

        return maxAve;
    }


}
