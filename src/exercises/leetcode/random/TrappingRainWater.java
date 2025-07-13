package exercises.leetcode.random;


public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {4,2,3};

        System.out.println(new TrappingRainWater().trapAlternate(height));



    }



    public int trap(int[] height) {
        int water = 0;
        int left = 0;
        int right = height.length-1;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left<right){

            // двигаем сторону с меньшей максимальной высотой
            if (leftMax>rightMax){
                right--;
                // обновляем максимум
                rightMax = Math.max(height[right], rightMax);
                water+=rightMax-height[right];
            }
            else {
                left++;
                leftMax = Math.max(height[left], leftMax);
                water+=leftMax-height[left];
            }
        }

        return water;
    }

    public int trapAlternate(int[] height){

        int water = 0;


        // для каждого блока вычисляем максимум слева
        int[] leftMax = new int[height.length];
        leftMax[0]=  height[0];
        for (int x = 1; x<height.length; x++){
            leftMax[x] = Math.max(leftMax[x-1], height[x]);
        }


        // для каждого бока вычисляем максимум справа

        int[] rightMax = new int[height.length];

        rightMax[height.length-1] = height[height.length-1];
        for (int x = height.length-2; x>=0; x--){
            rightMax[x]=  Math.max(rightMax[x+1], height[x]);
        }

        // считаем воду, ориентируясь на меньшее значение высоты

        for (int x = 0; x<height.length; x++){
            int value = height[x];
            int limit = Math.min(leftMax[x], rightMax[x]);

            water+=limit-value;
        }


        return water;

    }


}
