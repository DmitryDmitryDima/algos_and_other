package exercises.leetcode.prefixSum;

import java.util.Arrays;

public class LongestSequenceWithLimitedSum {


    public static void main(String[] args) {

        int[] nums = {2,3,4,5};
        int[] queries = {1};

        System.out.println(Arrays.toString(new LongestSequenceWithLimitedSum().answerQueries(nums, queries)));
    }
    public int[] answerQueries(int[] nums, int[] queries) {

        Arrays.sort(nums);
        int[] output = new int[queries.length];

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int x = 1; x<prefix.length;x++){
            prefix[x] = prefix[x-1]+nums[x];
        }
        for (int i = 0; i<queries.length; i++){
            // значение суммы - это то, что должно быть больше prefix[middle]
            int sum = queries[i];

            int start = 0;
            int end = prefix.length-1;
            int middle = (start+end)/2;
            int best = -1;
            while (start<=end){
                int value = prefix[middle];
                if (value>sum){
                    end = middle-1;
                }
                else if (value == sum) {
                    best = middle;
                    break;
                }
                else if (value<sum) {
                    start= middle+1 ;
                    best = middle;
                }

                middle = (start+end)/2;
            }

            output[i] = best+1;


        }

        return output;
    }
}
