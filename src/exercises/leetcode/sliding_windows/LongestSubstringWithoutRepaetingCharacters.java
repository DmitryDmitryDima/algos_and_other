package exercises.leetcode.sliding_windows;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LongestSubstringWithoutRepaetingCharacters {
    public static void main(String[] args) {
        String s = "aabaabxbb";




        System.out.println(lengthOfLongestSubstring(s));
    }


    private static  int lengthOfLongestSubstring(String s) {

        if (s.length()==1 || s.isEmpty()){
            return s.length();
        }


        int longest = 0;

        int left = 0;
        int right = 1;

        HashMap<Character, Integer> database = new HashMap<>();
        database.put(s.charAt(0),0);


        while (right!=s.length()){

            Character value = s.charAt(right);


            if (database.containsKey(value)){


                int size = database.size();
                if (size>longest){
                    longest = size;
                }



                int position = database.get(value);




                for (int x = left; x<position+1; x++){
                    Character toDelete = s.charAt(x);
                    database.remove(toDelete);

                }
                database.put(value, right); // обновление позиции right
                left = position+1;

                right++;

            }

            else {



                database.put(value, right);

                int size = database.size();
                if (size>longest){
                    longest = size;
                }
                right++;


            }

        }

        return longest  ;
    }

}
