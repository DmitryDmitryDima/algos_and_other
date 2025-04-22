package exercises.leetcode;

import java.util.*;

public class LongestConsecutiveSequence {


    public static void main(String[] args) {


        int [] nums = {100,4,200,1,3,2,5};

        System.out.println(new LongestConsecutiveSequence().longestConsecutiveAlt(nums));


    }


    public int longestConsecutiveAlt(int[] nums){

        HashSet<Integer> hashSet = new HashSet<>();

        Arrays.stream(nums).forEach(hashSet::add);

        int max = 0;
        for (int num:hashSet){

            // смысл этой строчки в том, чтобы не повторить уже задействованную цепочку
            if (!hashSet.contains(num-1)){

                int counter = 1;
                int currentNum = num;

                while(hashSet.contains(currentNum+1)){
                    counter++;
                    currentNum++;
                    max = Math.max(counter, max);

                }
            }
        }

        return max;
    }







    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();


        for (int num : nums) {
            heap.offer(num);


        }

        int currentMax = 1;
        int counter = 1;
        int previous = Integer.MAX_VALUE;

        while (!heap.isEmpty()){
            int value = heap.remove();
            System.out.println(value+" value "+previous+" previous");


            if (Math.abs(value-previous) == 1){
                counter++;
                if (currentMax<counter) currentMax++;
                previous = value;

            }

            else if ((value - previous) ==0){
                previous = value;
            }

            else {
                counter = 1;
                previous = value;
            }




        }


        return currentMax;
    }




}
