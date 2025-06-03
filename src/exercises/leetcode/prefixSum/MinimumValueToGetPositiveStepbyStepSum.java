package exercises.leetcode.prefixSum;

public class MinimumValueToGetPositiveStepbyStepSum {


    public static void main(String[] args) {

        int[] sample = {1,2};

        System.out.println(new MinimumValueToGetPositiveStepbyStepSum().minStartValue(sample));
    }

    public int minStartValue(int[] nums) {



        int smallest = nums[0];

        for (int i = 1; i<nums.length; i++){
            int value = nums[i]+nums[i-1];
            nums[i] = value;
            if (value<smallest) smallest=value;

        }

        if (smallest>0) return 1;
        else return 1-smallest;


    }
}




