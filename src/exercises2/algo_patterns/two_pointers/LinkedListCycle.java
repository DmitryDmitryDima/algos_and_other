package exercises2.algo_patterns.two_pointers;

import exercises.leetcode.two_pointers.ListNode;


// метод флойда - быстрый указатель в два раза быстрее, чем медленный
public class LinkedListCycle {


    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }



    public boolean hasCycle(ListNode head) {

        if (head == null) return false;


        var slowPointer = head;
        var fastPointer = head.next;



        //

        while (true) {

            if (slowPointer == null || fastPointer == null){
                return false;
            }

            if (slowPointer == fastPointer){
                return true;
            }

            slowPointer = slowPointer.next;

            if (fastPointer.next == null){

                //
                return false;
            }
            else {

                fastPointer=
                        fastPointer.next.next;

            }

        }

    }
}
