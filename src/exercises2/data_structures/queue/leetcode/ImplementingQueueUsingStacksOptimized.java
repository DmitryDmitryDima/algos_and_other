package exercises2.data_structures.queue.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;



// суть оптимизации - при вставке - всегда вставляем в direct stack
// при удалении - если зеркало пустое - перетаскиваем текущие элементы из direct в mirror. Удаляем из mirror
// при последующих операциях мы будем удалять из mirror до тех пор пока он не опустеет, делая часть операций O(1)
public class ImplementingQueueUsingStacksOptimized {



    static void main(){
        ImplementingQueueUsingStacks.SomeQueue someQueue = new ImplementingQueueUsingStacks.SomeQueue();

        someQueue.push(1);

        someQueue.push(2);

        System.out.println(someQueue.peek());

        System.out.println(someQueue.pop());

        System.out.println(someQueue.peek());
        System.out.println(someQueue.pop());


    }



    static class SomeQueue{



        private final Deque<Integer> directStack;

        private final Deque<Integer> mirrorStack;



        public SomeQueue() {


            directStack = new ArrayDeque<>();
            mirrorStack = new ArrayDeque<>();
        }

        public void push(int x) {

            directStack.push(x);




        }

        public int pop() {


            if (mirrorStack.isEmpty()){
                while (!directStack.isEmpty()){
                    mirrorStack.push(directStack.pop());
                }
            }

            return mirrorStack.pop();







        }

        public int peek() {
            if (mirrorStack.isEmpty()){
                while (!directStack.isEmpty()){
                    mirrorStack.push(directStack.pop());
                }
            }

            return mirrorStack.peek();

        }

        public boolean empty() {

            return directStack.isEmpty() && mirrorStack.isEmpty();
        }
    }
}
