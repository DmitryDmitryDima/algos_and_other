package exercises2.algo_patterns.sliding_window;

import java.util.*;

/*
придумал свою модель данных, но тут можно решить через частоту

 */
public class LongestHarmoniousSequence {


    static void main() {


        int[] nums = {1,3,2,2,5,2,3,7};

        System.out.println(findLHS(nums));


    }

    public static int findLHS(int[] nums) {



        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int value:nums){



            frequency.compute(value, (k, v)->{
               if (v == null){
                   return 1;
               }

               else {
                   return v+1;
               }
            });
        }

        int harmony = 0;

        for (Map.Entry<Integer, Integer> entry:frequency.entrySet()){

            int next = entry.getKey()+1;

            Integer nextFrequency = frequency.get(next);

            if (nextFrequency!=null && harmony<nextFrequency+entry.getValue()){
                harmony = nextFrequency+entry.getValue();
            }
        }

        return harmony;

        /*
        Arrays.sort(nums);



        class Chunk {
            int start;
            int end;
            int value;


            @Override
            public String toString() {
                return "Chunk{" +
                        "start=" + start +
                        ", end=" + end +
                        ", value=" + value +
                        '}';
            }
        }

        List<Chunk> chunks = new ArrayList<>();

        Chunk current = new Chunk();



        chunks.add(current);

        current.value = nums[0];


        for (int i = 0; i<nums.length; i++){

            int value = nums[i];

            if (value!= current.value){

                current = new Chunk();



                current.value = value;
                current.start = i;
                current.end = i;

                chunks.add(current);
            }

            else {
                current.end = i;
            }
        }


        Chunk previous = null;

        int maxHarmony = 0;

        for (Chunk chunk:chunks){
            if (previous!=null){
                var diff = chunk.value - previous.value;
                if (diff == 1){
                    var harmony = chunk.end-previous.start+1;

                    if (harmony>maxHarmony){
                        maxHarmony = harmony;
                    }
                }
            }

            previous = chunk;
        }


        return maxHarmony;



         */










    }


}
