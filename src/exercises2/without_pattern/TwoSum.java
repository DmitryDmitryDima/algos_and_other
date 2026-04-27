package exercises2.without_pattern;

import java.util.HashMap;

public class TwoSum {


    static void main(){

    }

    public int[] twoSum(int[] nums, int target) {


        HashMap<Integer, Integer> storage = new HashMap<>();

        int[] output = new int[2];

        storage.put(nums[0], 0); // значение, индекс

        for (int i =1; i<nums.length; i++){

            int value = nums[i];

            // left + right = target

            Integer leftIndex = storage.get(target-value);

            if (leftIndex!=null){
                output[0] = leftIndex;
                output[1] = i;
                break;
            }

            storage.put(value, i);

        }

        return output;


    }
}
