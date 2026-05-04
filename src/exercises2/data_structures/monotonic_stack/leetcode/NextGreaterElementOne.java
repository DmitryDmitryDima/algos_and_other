package exercises2.data_structures.monotonic_stack.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;



// в монотонном стэке порядок возрастания считается со "дна" (конца стэка)

// то есть increasing - значит верхний элемент стэка - самый большой, decreasing - верхний элемент - самый мелкий
public class NextGreaterElementOne {




    static void main(){

        int[] nums1 = {2,4};

        int[] nums2 = {1,2,3,4};

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));


    }



    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Deque<Integer> stack = new ArrayDeque<>();

        // значение + следующий больший элемент
        HashMap<Integer, Integer> database = new HashMap<>();

        for (int value : nums2) {

            while (!stack.isEmpty()) {


                int peek = stack.peek();
                // по правилу decreasing stack - вставляемое значение должно быть меньше чем peek
                if (value < peek) {
                    stack.push(value);
                    break;

                }
                // если значение больше, ты мы удаляем элемент из стэка
                else {
                    int popped = stack.pop();

                    database.put(popped, value);
                }

            }

            if (stack.isEmpty()) {
                stack.push(value);
            }

        }

        for (int v:stack){
            database.put(v, -1);
        }



        for (int i = 0; i<nums1.length; i++){

            nums1[i] = database.get(nums1[i]);
        }

        return nums1;

    }
}
