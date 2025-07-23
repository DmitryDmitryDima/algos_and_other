package exercises.leetcode.sliding_windows;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

    public static void main(String[] args) {

        int[] input = {1,2,2,1};
        System.out.println(new LongestHarmoniousSubsequence().findLHS(input));
    }

    public int findLHS(int[] nums) {

        // считаем частоты
        int max = 0;
        HashMap<Integer, Integer> stats = new HashMap<>();

        for (Integer i:nums){
            stats.put(i, stats.getOrDefault(i, 0)+1);
        }

        // анализируем соседей
        for (int i: stats.keySet()){
            if (stats.containsKey(i+1)){
                int count = stats.get(i+1) + stats.get(i);

                max = Math.max(count, max);
            }
        }



        return max;
    }

}



