package exercises2.algo_patterns.two_pointers;



// легкая задача на медленный и быстрый указатели. Быстрый проверяет, равно ли число на его локации с числом
// на локации медленного. Если нет - двигаем левый, занося в новое место значение, если - правый.
public class RemoveDublicatesFromSortedArray {



    public int removeDuplicates(int[] nums) {



        int slow = 0;

        for (int fast = 1; fast<nums.length; fast ++){

            int fastValue = nums[fast];

            int slowValue = nums[slow];

            if (fastValue!=slowValue){
                slow++;
                nums[slow]=fastValue;
            }


        }

        return slow+1;



    }
}
