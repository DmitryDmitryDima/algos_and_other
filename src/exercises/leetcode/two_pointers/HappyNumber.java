package exercises.leetcode.two_pointers;

import java.util.Arrays;
import java.util.HashMap;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 19;
        System.out.println(new HappyNumber().isHappyTwoPointers(n));
    }


    public boolean isHappyTwoPointers(int n) {

        int slow = n;
        int fast = getNext(n);

        while (fast!=1 && slow!=fast){
            fast = getNext(getNext(fast));
            slow = getNext(slow);
        }

        return fast==1;
    }

    private int getNext(int n){
        int sum = 0;

        while (n>0){
            int digit = n%10;
            sum+=digit;
            n/=10;
        }

        return sum;
    }



    public boolean isHappy(int n) {

        return recursion(n, new HashMap<>());
    }

    private boolean recursion(int n, HashMap<Integer, Integer> antiLoop){
        if (n==1){
            return true;
        }
        if (antiLoop.get(n)!=null) return false;



        else {

            antiLoop.put(n,0);

            int sum = 0;

            while (n>0){
                int digit = n%10;
                sum+=digit*digit;
                n/=10;
            }


            return recursion(sum, antiLoop);
        }
    }


}
