package exercises.leetcode.two_pointers;

public class LinkedListCycle {

    public static void main(String[] args) {
        // [3,2,0,4]
        ListNode head = new ListNode(3);

        head.next = new ListNode(2);


        System.out.println(new LinkedListCycle().hasCycle(null));
    }

    public boolean hasCycle(ListNode head) {


        if (head == null || head.next == null) {
            return false;

        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow!=fast){
            if (fast == null || fast.next==null){
                return false;
            }

            // заяц обгоняет черепаху
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

}




