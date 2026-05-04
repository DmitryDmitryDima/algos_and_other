package exercises2.data_structures.queue.leetcode;

import jdk.jfr.Frequency;

import java.util.HashMap;


// очередь хранит порядок поступления
public class FirstUniqueCharInString {



    static void main(){

        String chunk = "loveleetcode";
        System.out.println(firstUniqChar(chunk));

    }


    public static int firstUniqChar(String s) {



        HashMap<Character, Integer> base = new HashMap<>();



        for (char ch:s.toCharArray()){

            base.compute(ch, (k, v)->{

                if (v == null){
                    return 1;
                }

                else {
                    return v+1;
                }
            });


        }

        for (int i = 0; i<s.length(); i++){

            char value = s.charAt(i);

            if (base.get(value) == 1) return i;
        }









        return -1;



    }
}
