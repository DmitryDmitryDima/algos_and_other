package exercises2.data_structures.stack.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;



// используем технику прокручивания
public class ImplementingStackUsingQueues {








    static void main(){
        SomeStack stack = new SomeStack();

        stack.push(1);

        stack.push(2);


        System.out.println(stack.top());

        System.out.println(stack.pop());

        System.out.println(stack.top());

        System.out.println(stack.pop());

    }



    static class SomeStack{

        private Queue<Integer> directQueue;




        public SomeStack(){
            this.directQueue = new ArrayDeque<>();


        }


        public void push(int x) {

            directQueue.offer(x);

        }

        public int pop() {


            for (int i = 0; i<directQueue.size()-1; i++){

                int head = directQueue.poll();

                directQueue.offer(head);
            }

            return directQueue.poll();

        }


        // отлчие в том, что мы выполняем полный круг
        public int top() {
            for (int i = 0; i<directQueue.size(); i++){

                int head = directQueue.poll();

                directQueue.offer(head);

                if (i == directQueue.size()-1){
                    return head;
                }
            }





            return -1;
        }

        public boolean empty() {
            return directQueue.isEmpty();
        }


    }
}
