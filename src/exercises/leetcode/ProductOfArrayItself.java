package exercises.leetcode;

import java.util.Arrays;

public class ProductOfArrayItself {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductOfArrayItself().productExceptSelf(new int[]{
                1, 2, 3, 4
        })));
    }


    public int[] productExceptSelf(int[] nums) {


        Point[] points = new Point[nums.length];

        int starter = 1;
        for (int i = 0; i<nums.length; i++){
            points[i] = new Point();
            int value = nums[i];

            points[i].previous=starter;
            starter = starter*value;


        }

        starter = 1;

        for (int i = nums.length-1; i>=0; i--){
            int value = nums[i];
            points[i].next = starter;
            starter = starter*value;
        }

        int[] result = new int[nums.length];

        for (int x = 0; x<nums.length; x++){
            result[x] = points[x].next * points[x].previous;
        }



        return result;
    }
}


class Point{
    int previous;
    int next;
}
