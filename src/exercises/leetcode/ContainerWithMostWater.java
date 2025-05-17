package exercises.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ContainerWithMostWater {


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithMostWater().maxArea(height));

    }

    public int maxAreaOptimized(int[] height){
        int left = 0;
        int right = height.length-1;
        int max = 0;

        while (left<right){
            int xAxis = right - left;
            int yAxis = Math.min(height[left], height[right]);
            int volume = xAxis*yAxis;
            if (max<volume){
                max = volume;
            }

            if (height[right]>height[left]){
                left++;
            }
            else {
                right --;
            }

        }
        return max;
    }

    public int maxArea(int[] height) {


        class Height implements Comparable<Height> {
            int value;
            int right;
            int left;

            public Height(int value, int right, int left) {
                this.value = value;
                this.right = right;
                this.left = left;
            }

            @Override
            public int compareTo(Height o) {
                return -Integer.compare(value, o.value);
            }

            @Override
            public String toString() {
                return "Height{" +
                        "value=" + value +
                        ", right=" + right +
                        ", left=" + left +
                        '}';
            }
        }


        PriorityQueue<Height> heap = new PriorityQueue<>();

        int left = 0;
        int right = height.length-1;

        while (left<right){
            int xAxis = right - left;
            int yAxis = Math.min(height[left], height[right]);

            heap.offer(new Height(xAxis*yAxis, left, right));

            if (height[right]>height[left]){
                left++;
            }
            else {
                right --;
            }

        }



        return heap.peek().value;
    }
}
