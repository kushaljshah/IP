package LeetCode.Popular.Easy.LinkedList;

/**
 * Created by kushal.shah
 */
public class ReverseLinkedList {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int value){
            this.val = value;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null){
            ListNode nextTmp = current.next;
            current.next = prev;

            prev = current;
            current = nextTmp;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = null;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = null;

        ListNode current = node1;
        while (current != null){
            System.out.print(current.val);
            System.out.print("->");
            current = current.next;
        }
        System.out.println("");

        reverseList(node1);

        ListNode current1 = node5;
        while (current1 != null){
            System.out.print(current1.val);
            System.out.print("->");
            current1 = current1.next;
        }
    }
}
