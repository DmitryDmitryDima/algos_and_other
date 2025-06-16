package exercises.leetcode.two_pointers;

public class RemoveDublicatesFromSortedArray {

    public static void main(String[] args) {
        int[] sorted = {0,0,1,1,1,2,2,3,3,4};


        System.out.println(new RemoveDublicatesFromSortedArray().removeDuplicates(sorted));


    }


    public int removeDuplicates(int[] nums) {

        int slow = 0;
        int fast = 1;

        int count = 1;

        while (fast<nums.length){
            if (nums[fast]!=nums[fast-1]){
                nums[slow+1] = nums[fast];
                slow++;
                fast++;
                count++;
            }
            else {
                fast++;
            }
        }

        return count;
    }
}
