package exercises.leetcode.prefixSum;

public class RangeSumQuery {

    public static void main(String[] args) {
        int[] origin = {-2,0,3,-5,2,-1};
        System.out.println(new RangeSumQuery(origin).sumRange(4, 5));

    }

    private int[] prefix;
    public RangeSumQuery(int[] nums) {
        //
        this.prefix = nums;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i-1]+prefix[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left==0) return prefix[right];
        return prefix[right] - prefix[left-1];
    }
}
