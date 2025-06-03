package exercises.leetcode.prefixSum;

import java.util.HashMap;
import java.util.HashSet;

public class PivotIndex {

    public static void main(String[] args) {

        int[] input = {1,7,3,6,5,6};
        System.out.println(new PivotIndex().pivotIndexSimple(input));
    }

    public int pivotIndexSimple(int[] nums){

        int totalSum = 0;

        for (int i:nums){
            totalSum+=i;
        }

        int leftSum = 0;
        for (int x = 0; x<nums.length; x++){
            int value = nums[x];


            int rightSum = totalSum - leftSum;

            if ((rightSum - value) == leftSum) {
                return x;
            }
            leftSum = value+leftSum;

        }

        return -1;
    }

    public int pivotIndex(int[] nums) {


        int index = -1;

        int[] forward = nums.clone();




        for (int x = 1; x<nums.length; x++){
            forward[x] = forward[x-1]+forward[x];


        }
        int sum = nums[nums.length-1];

        if (sum == forward[nums.length-1]) {
            index = nums.length-1;
        }
        for (int x = nums.length-2; x>=0; x-- ){
            sum  = sum+nums[x];

            if (sum == forward[x]){
                index = x;
            }

        }




        return index;
    }

}
