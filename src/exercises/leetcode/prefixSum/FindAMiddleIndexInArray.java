package exercises.leetcode.prefixSum;

import java.util.Arrays;

public class FindAMiddleIndexInArray {

    public static void main(String[] args) {

        int[] nums = {4,0};
        System.out.println(new FindAMiddleIndexInArray().findMiddleIndex(nums));
    }

    public int findMiddleIndex(int[] nums) {


        int totalSum = Arrays.stream(nums).sum();

        int leftSum = 0;
        for (int i = 0; i<nums.length; i++){
            int value = nums[i];


            int rightSum = totalSum - value-leftSum;
            if (rightSum == leftSum) return i;
            leftSum+=value;
        }
        return -1;
    }
}
