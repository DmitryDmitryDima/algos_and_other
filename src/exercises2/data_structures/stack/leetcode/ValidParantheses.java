package exercises2.data_structures.stack.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParantheses {


    static void main(){


    }

    public boolean isValid(String s) {


        Deque<Character> deque = new ArrayDeque<>();




        for (char el:s.toCharArray()){

            if (el == '{' || el ==  '[' || el == '(' ){

                deque.push(el);
            }

            else {

                if (deque.isEmpty()) return false;

                char removed = deque.pop();

                if (el == '}' && removed!='{'){
                    return false;
                }

                if (el == ']' && removed!= '['){
                    return false;
                }

                if (el == ')' && removed!= '('){
                    return false;
                }




            }

        }

        return deque.isEmpty();


    }
}
