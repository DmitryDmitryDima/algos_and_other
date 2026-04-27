package exercises2.algo_patterns.prefix_sum;

import java.util.Arrays;
import java.util.HashMap;
/*
нужно найти количество подмассивов, встречающихся в массиве с суммой k.
Основа решения - формула вычисления суммы подмассива в prefix array - sub[right] - sub[left] = k
В мапу мы записываем в качестве ключа значение right,
при возникновении которого впереди формула выше даст ответ k, в качестве значение - сколько таких "ожидающих" накопилось

Мы проходимся по оригинальному массиву, считая префиксную сумму. Проверяем, есть ли в мапе значение ключа, равное текущему.
Если да - то обновляем счетчик на количество ожиданий. Если текущий префикс уже равен k, то дополнительно обнволяем счетчик на 1.

Далее мы вычисляем для текущего значения prefix нужное значение right, после чего заносим его в мапу,
ставя 1 - если это первая запись, инкрементируя - если нет.
 */
public class SubarraySumEqualsK {

    static void main(){

        var problem = new SubarraySumEqualsK();
        int[] nums = {0,0,0,0,0,0,0,0,0,0}; // 2
        int k = 0;
        System.out.println(problem.subarraySum(nums, k));


    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> storage = new HashMap<>();
        int current = 0;
        int occured = 0;



        for (int num : nums) {

            // rigth - left = current

            // we need to save needed "right" for every left

            // update current
            current = num+current;

            if (current == k){
                occured++;
            }

            // check if current value is actually needed value for previous left's

            Integer previousLeftCount = storage.get(current);

            if (previousLeftCount!=null){
                occured+=previousLeftCount;
            }

            // needed value
            int iNeed = current + k;

            // insert it
            storage.compute(iNeed, (key, value)->{
                if (value == null) return 1;
                else return ++value;
            });




        }

        return occured;


    }
}
