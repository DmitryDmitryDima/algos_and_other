package exercises.leetcode.fast_and_slow_pointers;

import exercises.leetcode.two_pointers.ListNode;

public class LinkedListCycle {


    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head){

        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = slow.next;
        // в цикле они встретятся
        while (slow!=fast){
            // в зацикленной структуре не может быть выхода к null
            if (fast==null || fast.next==null){
                return false;
            }
            slow = slow.next;
            // скорость быстрее, чем у slow
            fast = fast.next.next;
        }
        return true;
    }


}
