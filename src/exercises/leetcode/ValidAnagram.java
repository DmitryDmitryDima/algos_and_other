package exercises.leetcode;

import java.util.HashMap;

public class ValidAnagram {

    public static void main(String[] args) {


        System.out.println(new ValidAnagram().isAnagram("cat", "cat"));

    }

    public boolean isAnagram(String s, String t) {

        if (s.length()!=t.length()) return false;

        // анаграма - слово с тем же набором символов, что и у оригинала => cat tac

        HashMap<Character, Integer> chart = new HashMap<>();

        for (char x:s.toCharArray()){
            if (!chart.containsKey(x)){
                chart.put(x, 1);
            }

            else {
                chart.put(x, chart.get(x)+1);

            }
        }



        for (char x:t.toCharArray()){
            if(!chart.containsKey(x)) return false;

            chart.put(x, chart.get(x)-1);
        }



        for (int x:chart.values()){
            if (x!=0) return false;
        }


        return true;
    }
}
