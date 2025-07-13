package exercises.leetcode.random;


import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3,2,4}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {


        HashMap<Integer, Integer> database = new HashMap<>();
        int[] result = new int[2];

        for (int x = 0; x<nums.length; x++){


            int value = nums[x];

            int toTarget = target - value;

            Integer check = database.get(toTarget);
            if (check!=null){
                result[0] = x;
                result[1] = check;
                break;
            }

            database.put(value, x);


        }
        System.out.println(database);



        return result;
    }


}
