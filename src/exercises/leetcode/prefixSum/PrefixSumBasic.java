package exercises.leetcode.prefixSum;


import java.util.Arrays;

public class PrefixSumBasic {


    public static void main(String[] args) {
        int[] origin = {10,15,20,10,5};
        int[] prefixSum = createPrefixSumArray(origin);
        System.out.println(Arrays.toString(prefixSum)); // [10, 25, 45, 55, 60]
    }


    static int[] createPrefixSumArray(int[] origin){

        int[] prefixSum = new int[origin.length];
        prefixSum[0] = origin[0];
        for (int i = 1; i < origin.length; i++) {
            prefixSum[i] = prefixSum[i-1] + origin[i];
        }

        return prefixSum;

    }




}
