package exercises.leetcode.sliding_windows;

import java.util.Arrays;

public class MinimumSizeSubArraySum {

    public static void main(String[] args) {
        int target = 7;

        int[] nums = {2,3,1,2,4,3};

        System.out.println(minSubArrayLen(target, nums));
    }

    // при достижении target двигаем left, если меньше target - двигаем right
    public static  int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int right = 0;
        int currentSum = nums[left];
        int min =Integer.MAX_VALUE;

        while (true){
            System.out.println(left+" "+right);

            if (currentSum>=target){
                min = Math.min(min, right-left+1);
                currentSum-=nums[left];
                left++;
            }

            else {
                right++;
                if (right==nums.length){
                    break;
                }
                currentSum+=nums[right];


            }
        }

        return min==Integer.MAX_VALUE?0:min;
    }


}
