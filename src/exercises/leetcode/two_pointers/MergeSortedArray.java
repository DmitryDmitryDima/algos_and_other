package exercises.leetcode.two_pointers;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        new MergeSortedArray().merge(nums1, m, nums2,n);


    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1clone = nums1.clone();

        int first = 0;
        int second = 0;
        int commonPointer = 0;

        while (commonPointer<nums1.length){

            if (first>=m) {
                nums1[commonPointer] = nums2[second];
                second++;
            }

            else if (second>=n){
                nums1[commonPointer] = nums1clone[first];
                first++;
            }
            else {
                int firstValue = nums1clone[first];
                int secondValue = nums2[second];

                System.out.println(firstValue);
                System.out.println(secondValue);

                if (firstValue<=secondValue){
                    nums1[commonPointer] = firstValue;
                    first++;
                }
                else {
                    nums1[commonPointer] = secondValue;
                    second++;
                }
            }

            commonPointer++;
        }


    }
}
