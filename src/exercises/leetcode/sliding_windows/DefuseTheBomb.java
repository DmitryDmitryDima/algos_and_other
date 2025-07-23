package exercises.leetcode.sliding_windows;

import java.util.Arrays;

public class DefuseTheBomb {

    public static void main(String[] args) {
        int [] code = {2,4,9,3};
        int k = -2;
        System.out.println(Arrays.toString(new DefuseTheBomb().decrypt(code, k)));
    }


    public int[] decrypt(int[] code, int k) {
        int[] output = new int[code.length];

        int left = 0;
        int rigth = 0;
        int sum = 0;
        // разные стратегии формирования окна - оно либо сзади. либо спереди
        if (k>0){
            left = 1;
            rigth = left+k-1;

        }


        if (k<0){
            left = code.length+k;
            rigth = left-k-1;

        }

        // формируем изначальную сумму в окне

        for (int x = left; x<=rigth; x++){
            sum+=code[x];
        }








        for (int x = 0; x<code.length; x++){
            if (k==0){
                output[x] = 0;
            }

            else {
                output[x] = sum;
                sum-=code[left];
                left++;

                rigth++;

                // если достинут предел - пробрасываем позицию в начало
                if (left == code.length){
                    left = 0;
                }
                if (rigth == code.length){
                    rigth = 0;
                }
                sum+=code[rigth];



            }


        }

        return output;
    }
}
