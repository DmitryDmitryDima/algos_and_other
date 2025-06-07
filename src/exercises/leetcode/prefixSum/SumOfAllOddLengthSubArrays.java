package exercises.leetcode.prefixSum;

import java.util.Arrays;

public class SumOfAllOddLengthSubArrays {


    public static void main(String[] args) {

        int[] sample = {1,4,2,5,3};
        System.out.println(new SumOfAllOddLengthSubArrays().sumOddLengthSubarrays(sample));
    }




    public int sumOddLengthSubarrays(int[] arr) {

        int[] prefixSum = arr.clone();

        for (int i = 1; i<arr.length; i++){
            prefixSum[i] = prefixSum[i-1]+prefixSum[i];
        }

        int subLength = 3;
        int totalSum = prefixSum[arr.length-1];

        while (subLength<=arr.length){

            int start = 0;
            int end = subLength-1;

            while (end<arr.length){

                totalSum+=prefixSum[end]-prefixSum[start]+arr[start];
                start++;end++;
            }

            subLength+=2;
        }

        return totalSum;
    }
}
