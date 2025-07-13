package exercises.leetcode.random;

import java.util.*;

public class ThreeSum {




    public static void main(String[] args) {

        int[] nums = {0,0,0,0};

        System.out.println(new ThreeSum().threePos(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        // сортируем
        Arrays.sort(nums);
        List<List<Integer>> outputData = new ArrayList<>();

        int pos = 0;
        while (pos < nums.length - 2) {
            int target = -nums[pos];
            int start = pos + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == target) {
                    outputData.add(List.of(nums[pos], nums[start], nums[end]));
                    // Skip duplicates for `start` and `end`
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    // Move pointers after processing
                    start++;
                    end--;
                }
                else if (sum < target) {
                    start++;
                }
                else {
                    end--;
                }
            }
            // Skip duplicates for `pos`
            while (pos < nums.length - 2 && nums[pos] == nums[pos + 1]) pos++;
            pos++; // Move to next unique element
        }
        return outputData;
    }



    public List<List<Integer>> threePos(int[] nums){

        // сортируем массив
        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        // готовим data
        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++) {
            // пропускаем дубликаты для внешнего цикла (внимательно! - мы должны гарантировать,
            // что первое появление будет рассмотрено
            if (i>0 && nums[i]==nums[i-1]){
                System.out.println("dublicate "+nums[i]);
                continue;
            }

            int target = -nums[i];

            int start = i+1;
            int end = nums.length-1;

            while (start<end){
                if (nums[start]+nums[end] == target) {
                    output.add(List.of(nums[i], nums[start], nums[end]));

                    // скип дубликатов
                    while (start<end && nums[start]==nums[start+1]){
                        start++;
                    }
                    // скип дубликатов
                    while (start<end && nums[end]== nums[end-1]){
                        end--;
                    }
                    start++;
                    end--;
                }

                else if (nums[start]+nums[end]<target) {
                    start++;
                }
                else {
                    end--;
                }
            }

        }

        return output;
    }





}
