package exercises.leetcode.prefixSum;

import java.util.Arrays;

public class LeftAndRightSumDifferences {

    public static void main(String[] args) {
        int[] input = {1};

        System.out.println(Arrays.toString(new LeftAndRightSumDifferences().leftRightDifference(input)));
    }

    public int[] leftRightDifference(int[] nums) {
        int[] output = new int[nums.length];

        int total = 0;

        int[] leftSum = new int[nums.length];

        for (int i = 0; i<nums.length; i++){
            leftSum[i] = total;
            int value = nums[i];
            total+=value;
        }

        for (int i = 0; i<leftSum.length; i++){
            int left = leftSum[i];

            int right = total - nums[i]-left;

            output[i] = Math.abs(left - right);
        }

        return output;
    }
}
