package exercises2.algo_patterns.prefix_sum;

import java.util.Arrays;

/*
Легкая задача с поиском индекса,
где сумма левой стороны равна сумме правой.
Решил через расчет обратной prefix суммы,
после чего прошелся по массиву сначала,
сравнивая значение в prefixSum[x] и текущее значение прямого префикса + nums[value].
Основная сложность в том, чтобы осознать,
как используется текущее значение.
По сути в x оно является частью как обратного, так и прямого порядка
 */
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
