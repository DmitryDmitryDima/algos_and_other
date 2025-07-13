package exercises.leetcode.sliding_windows;

import java.util.HashMap;

public class ContainsDublicateTwo {


    public static void main(String[] args) {
        int k = 3;
        int[] input = {99,99};

        System.out.println(new ContainsDublicateTwo().containsDublicateSlidingWindow(input, k));
    }


    public boolean containsDublicateSlidingWindow(int[] nums, int k){
        HashMap<Integer, Integer> window = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (window.containsKey(nums[i])){
                return true;
            }
            window.put(nums[i], i);

            // двигаем окно вправо
            if (i>=k){
                window.remove(nums[i-k]);

            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {




        while (k>=1){
            int start = 0;
            int end = k;
            while (end<nums.length){
                if (nums[start]==nums[end]){
                    return true;
                }
                start++;
                end++;
            }
            k--;


        }

        return false;
    }

    public boolean containsDublicateAlternate(int[] nums, int k){

        HashMap<Integer, Integer> data = new HashMap<>();
        for (int x = 0; x<nums.length; x++){

            int value = nums[x];

            Integer answer = data.get(value);
            if (answer==null){
                data.put(value, x);
            }
            else {
                if (Math.abs(answer-x)<=k){
                    return true;
                }
                data.put(value, null);
            }

        }

        return false;
    }
}


