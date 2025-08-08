package exercises.leetcode.sliding_windows;

import java.util.*;


// this is divide & conquer !!
public class LongestNiceSubstring {
    public static void main(String[] args) {

        System.out.println(new LongestNiceSubstring().longestNiceSubstring("VaiOlVBrVyoGqygbrELjHNyRAVmHDhtSsvLMCIeFStnoyTygcrMduvyYfJQ"));


    }


    public String longestNiceSubstring(String s) {

        HashMap<Character, List<Integer>> database = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            List<Integer> indices = database.computeIfAbsent(s.charAt(i), (k)->new ArrayList<Integer>());
            indices.add(i);
            database.put(s.charAt(i), indices);


        }

        List<AbstractMap.SimpleEntry<String, Integer>> valid = new ArrayList<>();
        List<AbstractMap.SimpleEntry<String, Integer>> candidates = new ArrayList<>();
        candidates.add(new AbstractMap.SimpleEntry<>(s,0));

        int maxLength = 1;


        while (!candidates.isEmpty()){

            ArrayList<AbstractMap.SimpleEntry<String, Integer>> toRemove = new ArrayList<>();
            ArrayList<AbstractMap.SimpleEntry<String, Integer>> toAdd = new ArrayList<>();

            for (AbstractMap.SimpleEntry<String, Integer> candidate:candidates){
                System.out.println(candidate+" candidate");
                String string = candidate.getKey();
                Integer start = candidate.getValue();
                int end = start+string.length()-1;


                int i ;
                for (i = 0; i<string.length(); i++){
                    char letter = string.charAt(i);
                    Character pair = Character.isUpperCase(letter)?Character.toLowerCase(letter):Character.toUpperCase(letter);
                    List<Integer> indices = database.get(pair);
                    boolean isContain = false;
                    if (indices!=null){
                        for (int index:indices){
                            if (index>=start && index<=end){
                                isContain = true;
                                break;
                            }
                        }
                    }
                    if (!isContain){
                        AbstractMap.SimpleEntry<String, Integer> leftEntry = new AbstractMap.SimpleEntry<>(string.substring(0,i), start);
                        System.out.println("generate left pair "+leftEntry);
                        toAdd.add(leftEntry);
                        if (i!=string.length()-1){
                            AbstractMap.SimpleEntry<String,Integer> rightEntry = new AbstractMap.SimpleEntry<>(string.substring(i+1), start+i+1);
                            toAdd.add(rightEntry);
                            System.out.println("generate right pair "+rightEntry);
                        }

                        break;



                    }
                    //System.out.println(letter+" found pair "+pair);
                }

                // все символы имеют пару
                if (i==string.length() && i>=maxLength){
                    maxLength = string.length();
                    valid.add(candidate);
                }



                toRemove.add(candidate);

            }

            for (AbstractMap.SimpleEntry<String, Integer> tr:toRemove){
                candidates.remove(tr);

            }
            candidates.addAll(toAdd);

        }

        System.out.println(valid);

        AbstractMap.SimpleEntry<String, Integer> early = null;
        for (var v:valid){
            if (v.getKey().length()==maxLength){
                if (early == null) {
                    early = v;
                }
                else {
                    int start = v.getValue();
                    if (start<early.getValue()){
                        early = v;
                    }
                }
            };
        }








        return early==null?"":early.getKey();
    }




}
