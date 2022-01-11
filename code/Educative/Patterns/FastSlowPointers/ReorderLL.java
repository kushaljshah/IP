package Educative.Patterns.FastSlowPointers;

/**
 *
 *
 You are given the head of a singly linked-list. The list can be represented as:

 L0 → L1 → … → Ln - 1 → Ln
 Reorder the list to be on the following form:

 L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 You may not modify the values in the list's nodes. Only nodes themselves may be changed.



 Example 1:


 Input: head = [1,2,3,4]
 Output: [1,4,2,3]
 Example 2:


 Input: head = [1,2,3,4,5]
 Output: [1,5,2,4,3]
 *
 */

public class ReorderLL {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        one.next= two;
        two.next= three;
        three.next= four;
        four.next= five;
        five.next= six;

        reorderList(one);
        printLL(one);

    }

    public static void reorderList(ListNode head) {
        printLL(head);

        if(head.next != null) {
            //find the middle of the node
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            if (fast != null) {
                slow = slow.next;
            }

//            printLL(slow);

            ListNode curr = slow;
            ListNode prev = null;
            while (curr != null){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

//            printLL(prev);

            ListNode currNode = head;
            while (prev != null && currNode != null) {
                ListNode tmp = currNode.next;
                currNode.next = prev;
                ListNode tmp2 = prev.next;
                prev.next = tmp;
                currNode = tmp;
                prev = tmp2;
            }

            currNode.next = null;
        }


    }

    private static void printLL(ListNode head){
        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }

        System.out.println("");

    }
}
