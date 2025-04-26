package exercises.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumInputArrayIsSorted {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,6};

        System.out.println(Arrays.toString(new TwoSumInputArrayIsSorted().twoSum(array, 6)));
    }


    public int[] twoSum(int[] numbers, int target) {

        int start = 0;
        int end = numbers.length-1;

        while (start<end){

            int sum = numbers[start]+numbers[end];

            if (sum == target) return new int[]{start+1, end+1};

            else if (sum>target){
                end--;
            }
            else {
                start++;
            }


        }

        return new int[]{-1,-1};
    }
}
