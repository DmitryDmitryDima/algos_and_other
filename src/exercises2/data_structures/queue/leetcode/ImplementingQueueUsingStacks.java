package exercises2.data_structures.queue.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

// по сути это задачка на зеркальную природу стека по отношению к тому, кто является источником информации

public class ImplementingQueueUsingStacks {


    static void main(){
        SomeQueue someQueue = new SomeQueue();

        someQueue.push(1);

        someQueue.push(2);


    }



    static class SomeQueue{



        private final Deque<Integer> directStack;



        public SomeQueue() {


            directStack = new ArrayDeque<>();
        }

        public void push(int x) {

            directStack.push(x);




        }

        public int pop() {


            Deque<Integer> mirror = new ArrayDeque<>();


            while (!directStack.isEmpty()){
                mirror.push(directStack.pop());
            }



            int answer = mirror.pop();

            while (!mirror.isEmpty()){
                directStack.push(mirror.pop());
            }

            return answer;
        }

        public int peek() {

            Deque<Integer> mirror = new ArrayDeque<>();


            while (!directStack.isEmpty()){
                mirror.push(directStack.pop());
            }

            int answer = mirror.peek();

            while (!mirror.isEmpty()){
                directStack.push(mirror.pop());
            }


            return answer;
        }

        public boolean empty() {

            return directStack.isEmpty();
        }
    }
}
