package exercises.leetcode.prefixSum;

import java.util.Arrays;

public class MaximumScoreAfterSplittingTheString {


    public static void main(String[] args) {

        String s = "010";

        System.out.println(new MaximumScoreAfterSplittingTheString().maxScore(s));
    }


    public int maxScore(String s) {

        char zero = '0';
        char one = '1';
        char initial = s.charAt(0);
        char last = s.charAt(s.length()-1);

        int[] zeros = new int[s.length()], ones = new int[s.length()];


        zeros[0] = initial==zero?1:0;
        ones[s.length()-1] = last==one?1:0;

        for (int i = 1; i < zeros.length; i++) {

            char value = s.charAt(i);
            if (value == zero){
                zeros[i] = zeros[i-1]+1;
            }
            else {
                zeros[i] = zeros[i-1];
            }

        }

        for (int i = s.length()-2; i>=0; i--){
            char value = s.charAt(i);
            if (value == one){
                ones[i] = ones[i+1]+1;
            }
            else {
                ones[i] = ones[i+1];
            }
        }

        int max = 0;

        System.out.println(Arrays.toString(zeros)+" "+Arrays.toString(ones));

        for (int i = 0, j = 1; j<s.length(); i++, j++ ){
            int sum = zeros[i]+ones[j];



            System.out.println(sum);
            if (sum>max){
                max = sum;
            }
        }

        return max;
    }
}
