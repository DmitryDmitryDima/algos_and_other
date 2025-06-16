package exercises.leetcode.two_pointers;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {1,2,3,5,5,5,4,5};
        int val = 5;

        System.out.println(new RemoveElement().removeElement(nums, val));


    }


    public int removeElement(int[] nums, int val) {

        int slow = -1;


        for (int fast = 0; fast < nums.length; fast++) {

            if (nums[fast]!=val){

                nums[++slow] = nums[fast];

            }

        }


        return slow+1;
    }

}



