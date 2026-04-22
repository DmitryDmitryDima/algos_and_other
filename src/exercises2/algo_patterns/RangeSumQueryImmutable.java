package exercises2.algo_patterns;

import java.util.Arrays;

public class RangeSumQueryImmutable {


    static void main(){

        var example = new RangeSumQueryImmutable(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(example.sumRange(0, 2));


    }

    private int[] prefixSum;

    public RangeSumQueryImmutable(int[] nums){
        this.calculatePrefixSum(nums);
        System.out.println(Arrays.toString(prefixSum));
    }

    private void calculatePrefixSum(int[] nums){

        this.prefixSum = new int[nums.length];

        prefixSum[0] = nums[0];

        for (int x = 1; x<nums.length; x++){
            prefixSum[x] = nums[x]+prefixSum[x-1];
        }
    }
    public int sumRange(int left, int right) {
        if (left ==0) return prefixSum[right];
        else return prefixSum[right] - prefixSum[left-1];
    }

}
