package exercises.leetcode.prefixSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    public static void main(String[] args) {
        int[] original = {10, 2, -2, -20, 10};
        System.out.println(new SubArraySumEqualsK().subarraySum(original, -10));

    }

    public int subarraySum(int[] arr, int k) {
        // HashMap to store prefix sums frequencies
        Map<Integer, Integer> prefixSums = new HashMap<>();
        int res = 0;
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum so far.
            currSum += arr[i];

            // If currSum is equal to desired sum, then a new subarray is found.
            if (currSum == k)
                res++;

            // Check if the difference exists in the prefixSums map.
            if (prefixSums.containsKey(currSum - k))

                res += prefixSums.get(currSum - k); // может быть два разных подмассива, заканчивающихся на текущем элементе

            // Add currSum to the set of prefix sums.
            prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0) + 1);
        }

        return res;

    }

}
