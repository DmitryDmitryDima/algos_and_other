package exercises.leetcode.two_pointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA!=pointerB){
            pointerA = pointerA==null?headB:pointerA.next;
            pointerB = pointerB==null?headA:pointerB.next;
        }

        return pointerA;


    }
}
