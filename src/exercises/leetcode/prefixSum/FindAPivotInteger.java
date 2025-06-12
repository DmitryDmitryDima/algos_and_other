package exercises.leetcode.prefixSum;

import java.util.Arrays;

public class FindAPivotInteger {

    public static void main(String[] args) {
        int n = 4;

        System.out.println(new FindAPivotInteger().pivotInteger(n));
    }

    public int pivotInteger(int n) {

        int totalSum = 0;
        int[] prefix = new int[n];

        for (int i = 0; i<n; i++){
            totalSum+=i+1;
            prefix[i] = totalSum;
        }
        int value = 1;
        for (int s:prefix){
            int right = totalSum-s+value;
            if (right == s) return value;
            value++;

        }







        return n==1?1:-1;
    }
}
