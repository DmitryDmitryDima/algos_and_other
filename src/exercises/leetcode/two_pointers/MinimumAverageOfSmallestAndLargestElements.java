package exercises.leetcode.two_pointers;

import java.util.Arrays;

public class MinimumAverageOfSmallestAndLargestElements {


    public static void main(String[] args) {
        int[] input = {1,9,8,3,10,5};
        System.out.println(new MinimumAverageOfSmallestAndLargestElements().minimumAverage(input));
    }

    // ищем меньшее среднее число между парами больший-меньший элемент
    public double minimumAverage(int[] nums) {

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1;
        double smallest = Double.MAX_VALUE;
        while (left<right){
            double average = (nums[left] + nums[right]) /2.0; // внимание на это деление

            if (average<smallest) {
                smallest = average;
            }
            left++;
            right--;
        }


        return smallest;
    }
}
