package exercises.leetcode.two_pointers;

import java.util.ArrayList;

public class PalindromeLinkedList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        ListNode fast = head;
        ListNode slow = head;


        while (fast != null && fast.next != null) {


            slow = slow.next;

            fast = fast.next.next;

        }



        ListNode prev = slow;

        while (slow.next!=null){
            slow = slow.next;
            prev.next = prev;
            prev = slow;
        }

        System.out.println(prev.next);


    }

    public boolean isPalindrome(ListNode head) {



        ListNode pointer = head;
        ArrayList<Integer> content = new ArrayList<>();

        while (pointer!= null) {
            content.add(pointer.val);
            pointer = pointer.next;
        }

        pointer = head;

        int x = content.size()-1;
        while (x>=0){
            if (content.get(x)!=pointer.val){
                return false;
            }
            x--;
            pointer = pointer.next;
        }








        return true;
    }
}
