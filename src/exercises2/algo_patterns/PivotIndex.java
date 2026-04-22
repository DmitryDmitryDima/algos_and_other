package exercises2.algo_patterns;

import java.util.Arrays;

public class PivotIndex {



    static void main(){
        PivotIndex pivotIndex  = new PivotIndex();
        int[] input = {1,2,3};
        System.out.println(pivotIndex.pivotIndex(input));
    }

    public int pivotIndex(int[] nums) {



        int[] mirror = new int[nums.length];


        mirror[nums.length-1] = nums[nums.length-1];



        for (int x = nums.length-2; x>=0; x--){
            mirror[x] = mirror[x+1]+nums[x];
        }

        System.out.println(Arrays.toString(mirror));

        int value = 0;

        for (int x = 0; x<nums.length; x++){
            value = nums[x] + value;

            if (value ==mirror[x]){
                return x;
            }
        }


        return -1;


    }
}
