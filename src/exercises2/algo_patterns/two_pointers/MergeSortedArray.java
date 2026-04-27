package exercises2.algo_patterns.two_pointers;

import java.util.Arrays;

// по сути задачка представляет собой шаг классического merge sort алгоритма
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {


        int first = 0;
        int second = 0;

        int full = 0;

        int[] firstArray  =
                Arrays.copyOf(nums1, m);


        while (full<nums1.length){

            //

            if (first ==m){

                nums1[full]=nums2[second];
                second++;
                //
            }

            else if (second==n){
                nums1[full]=
                        firstArray[first];
                first++;




            }

            else {

                int fValue
                        = firstArray[first];

                int sValue =
                        nums2[second];

                if (fValue<sValue){
                    nums1[full]=fValue;
                    first++;

                }

                else {
                    //
                    nums1[full]=sValue;
                    second++;


                }



            }

            full++;

        }


    }
}
