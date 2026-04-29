package exercises2.data_structures.stack.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


// TODO ВАЖНАЯ ЗАДАЧА
public class PalindromeLinkedList {

    static void main(){


        ListNode node = new ListNode(1);

        node.next = new ListNode(0);

        node.next.next = new ListNode(1);

        //node.next.next.next = new ListNode(4);

        //node.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(node));


    }


    public static boolean isPalindrome(ListNode head) {


        if (head == null || head.next == null) return true;


        Deque<ListNode> stack = new ArrayDeque<>();

        ListNode current = head;



        while (current!=null){

            stack.push(current);



            current = current.next;






        }

        current = head;

        while (current!=null){


            ListNode popped = stack.pop();

            if (popped.val!= current.val) return false;



            current = current.next;






        }

        return true;




    }


    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }




}
