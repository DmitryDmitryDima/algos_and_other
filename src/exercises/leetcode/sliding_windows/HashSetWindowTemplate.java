package exercises.leetcode.sliding_windows;

import java.util.HashSet;

public class HashSetWindowTemplate {


    public static void main(String[] args) {

        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};

        HashSet<Integer> window = new HashSet<>();
        int windowSize = 5;

        for (int x = 0; x<windowSize;x++){
            window.add(array[x]);
        }

        int left = 1;
        int right = windowSize;
        System.out.println(window); // first window iteration
        while (right!=array.length){
            window.remove(array[left-1]);
            window.add(array[right]);
            System.out.println(window);
            right++;
            left++;
        }








    }
}
