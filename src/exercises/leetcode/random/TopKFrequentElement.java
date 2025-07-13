package exercises.leetcode.random;

import java.util.*;

public class TopKFrequentElement {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequentElement().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {


        HashMap<Integer, Integer> data = new HashMap<>();

        for (int x:nums){
            if (data.containsKey(x)){
                data.put(x, data.get(x)+1);

            }
            else {
                data.put(x, 1);

            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap =
                new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());

        for (var entry:data.entrySet()){
            heap.offer(entry);
        }




        int[] output = new int[k];

        for (int x = 0; x<k; x++){
            var peek = heap.remove();

            output[x] = peek.getKey();
        }


        return output;
    }
}
