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



        ListNode prev = new ListNode(slow.val);

        while (slow.next!=null){
            slow = slow.next;
            ListNode current = new ListNode(slow.val);
            current.next = prev;
            prev = current;


        }

        while (prev!=null){
            if (prev.val!=head.val){
                System.out.println("Alert");
                return;
            }
            prev = prev.next;
            head = head.next;
        }
        System.out.println("palindrome");


    }


    public boolean isPalindromeFloydVersion(ListNode head){
        if (head == null || head.next == null) return true;

        ListNode fast = head;
        ListNode slow = head;


        while (fast != null && fast.next != null) {


            slow = slow.next;

            fast = fast.next.next;

        }

        ListNode prev = null;
        ListNode current = slow;

        while (current.next!=null){

            ListNode next = new ListNode(current.val);
            current.next = prev;
            prev = current;
            current = next;


        }

        ListNode left = head;
        ListNode right = prev;

        while (prev!=null){
            if (prev.val!=head.val){

                return false;
            }
            prev = prev.next;
            head = head.next;
        }

        return true;
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
