package Educative.Patterns.CycleLL;

/**
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 */


public class ReverseLL {

    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        printLL(head);
        if(head == null || head.next == null)
            return head;

        ListNode prev = null;
        while (head!= null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        printLL(prev);
        return prev;
    }

    private static void printLL(ListNode head){
        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }

        System.out.println("");

    }

}
