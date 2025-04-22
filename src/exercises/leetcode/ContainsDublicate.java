package exercises.leetcode;

import java.util.HashSet;

public class ContainsDublicate {

    public static void main(String[] args) {

        System.out.println(new ContainsDublicate()
                .containsDublicate(new int[]{1, 2, 2, 4, 6}));
    }



    public boolean containsDublicate(int[] array){

        HashSet<Integer> hashset = new HashSet<>();

        for (int x:array){
            if (!hashset.add(x)) return true;
        }

        return false;

    }
}
