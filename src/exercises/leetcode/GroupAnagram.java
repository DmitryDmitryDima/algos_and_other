package exercises.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

    public static void main(String[] args) {
        System.out.println(new GroupAnagram().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<Integer>> data = new HashMap<>();
        for (int x = 0; x<strs.length; x++){

            char[] sorted = strs[x].toCharArray();
            Arrays.sort(sorted);
            String key = Arrays.toString(sorted);
            if (!data.containsKey(key)){
                List<Integer> list = new ArrayList<>();
                list.add(x);
                data.put(key, list);

            }
            else {
                List<Integer> list = data.get(key);
                list.add(x);
            }


        }

        List<List<String>> output = new ArrayList<>();

        for (List<Integer> list:data.values()){
            List<String> toAdd =new ArrayList<>();
            for (int x:list){
                toAdd.add(strs[x]);
            }
            output.add(toAdd);
        }



        return output;
    }
}
