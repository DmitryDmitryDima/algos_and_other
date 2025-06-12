package exercises.leetcode.prefixSum;

import java.util.Arrays;

public class CheckIfAllTheIntegersInARangeAreCovered {

    public static void main(String[] args) {

        int left = 1;
        int right = 50;
        int[][] ranges = {{1,5}};

        System.out.println(new CheckIfAllTheIntegersInARangeAreCovered().isCoveredDifferenceArray(ranges,left,right));

    }

    public boolean isCoveredDifferenceArray(int[][] ranges, int left, int right){
        int[] differenceArray = new int[52];

        for (int[] interval:ranges){
            differenceArray[interval[0]]++;
            differenceArray[interval[1]+1]--;
        }

        int[] prefixSum = new int[52];

        for (int i = 1; i<=50; i++){
            prefixSum[i] = prefixSum[i-1]+differenceArray[i];
        }

        System.out.println("Difference array "+Arrays.toString(differenceArray));
        System.out.println("Prefix sum       "+Arrays.toString(prefixSum));


        for (int i = left; i <= right; i++) {
            if (prefixSum[i] <= 0) {
                return false;
            }
        }


        return true;
    }

    public boolean isCovered(int[][] ranges, int left, int right) {

        int[] rangeCover = new int[51];

        for (int[] range:ranges){
            int start = range[0];
            int end = range[1];
            while (start<=end){
                rangeCover[start] = 1;
                start++;
            }
        }



        while (left<=right){
            if (rangeCover[left]!=1) return false;
            left++;
        }

        return true;
    }
}
