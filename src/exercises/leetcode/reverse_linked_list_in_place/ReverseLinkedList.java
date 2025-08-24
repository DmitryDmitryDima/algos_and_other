package exercises.leetcode.reverse_linked_list_in_place;

import java.util.List;

public class ReverseLinkedList {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);




        print(head);
        System.out.println("reverse");
        print(reverseListII(head, 1,2));


    }

    public static void print(ListNode head){
        ListNode current = head;
        while(current!=null){
            System.out.println(current.val);
            current = current.next;
        }
    }

    // задача для отзеркаливания всего связанного списка
    public static ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode previous = null;

        while (current!=null){
            ListNode next = current.next;
            // разворот
            current.next = previous;
            // сохранение предыдущего
            previous = current;
            current = next;

        }
        return previous;
    }




    // зеркалим часть списка, возвращаем его начало и конец для дальнейшего встраивания в структуру
    private static List<ListNode> reverseListChunk(ListNode start, ListNode end){


        ListNode forward = start;
        ListNode previous = null;
        ListNode backEnd = null;
        while (forward!=end.next){
            // для новой ноды предыдущее звено будет следующим
            ListNode backHead = new ListNode(forward.val);
            if (previous==null){
                backEnd = backHead;
            }
            backHead.next = previous;
            previous = backHead;
            forward = forward.next;
        }
        return List.of(previous,backEnd);
    }

    public static ListNode reverseListII(ListNode head, int left, int right){




        ListNode start = null;
        ListNode beforeStart = null;
        ListNode previous = null;

        ListNode current = head;
        List<ListNode> chunk;
        int pointer = 1;
        while(true){
            if (pointer == right){
                chunk = reverseListChunk(start, current);

                break;
            }
            if (pointer == left){
                start = current;
                beforeStart = previous;

            }
            pointer++;
            previous = current;
            current = current.next;
        }


        // встраиваем кусок в структуру, пользуясь зафиксированными выше позициями (до старта и current)

        if (beforeStart == null){
            head = chunk.get(0);
        }
        else {
            beforeStart.next = chunk.get(0);
        }



        chunk.get(1).next = current.next;



        return head;
    }


}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
