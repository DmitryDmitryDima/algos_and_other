package exercises2.algo_patterns.sliding_window;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// задачка с подвохом. Ширина окна - меньше или равна k

// оптимальное решение - sliding window + hashset

// чтобы удалять элементы из hashset, мы вычисляем позицию выпадающего элемента
public class ContainsDublicateTwo {


    static void main() {
        var problem = new ContainsDublicateTwo();

        int[] nums = {1,2,3,1};

        System.out.println(problem.containsNearbyDuplicate(nums, 3));



    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {



        HashSet<Integer> base = new HashSet<>();

        for (int x = 0; x<nums.length; x++){

            if (x>k){
                // нужно удалить элемент

                base.remove(nums[x-k-1]);
            }

            // пытаемся добавить новый элемент

            boolean result = base.add(nums[x]);

            System.out.println(base);

            if (!result) return true;
        }

        return false;


        /*


        int left = 0;

        int right = k;

        if (right>=nums.length){
            right = nums.length-1;
        }

        if (left == right) return false;

        HashSet<Integer> window = new HashSet<>();

        // заполняем окно
        for (int x = left; x<=right; x++){

            window.add(nums[x]);

            if (window.size()!=x+1){
                return true;
            }


        }

        System.out.println(window);

        // заранее двигаем right
        right++;

        while (right<nums.length){

            window.remove(nums[left]);
            left++;

            window.add(nums[right]);

            System.out.println(window);

            if (window.size()-1!=k){
                return true;
            }

            right++;
        }


        return false;


         */











        /*

        // value - index
        // в базе всегда будет последний встреченный индекс
        HashMap<Integer, Integer> storage = new HashMap<>();


        for (int x = 0; x<nums.length; x++){

            int value = nums[x];

            Integer previousDuplicate = storage.get(value);

            if (previousDuplicate !=null && x- previousDuplicate <=k){
                return true;
            }
            storage.put(value, x);
        }


        return false;

         */








    }
}
