package exercises.leetcode.fast_and_slow_pointers;

import exercises.leetcode.two_pointers.ListNode;

public class MiddleOfTheLinkedList {

    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {

        if (head ==null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null){

            slow = slow.next;

            if (fast.next == null){

                break;
            }

            fast = fast.next.next;
        }

        return slow;

    }
}
