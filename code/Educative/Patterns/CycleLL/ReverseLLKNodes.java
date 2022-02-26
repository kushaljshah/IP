package Educative.Patterns.CycleLL;


/**
 *
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 */

public class ReverseLLKNodes {
    ListNode leftBoundary = null;
    ListNode root = null;

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        one.next= two;
        two.next= three;
        three.next= four;
        four.next= five;
        five.next= six;
        six.next= seven;
        seven.next = null;

        ReverseLLKNodes reverseLLKNodes = new ReverseLLKNodes();
        reverseLLKNodes.printLL(one);
        ListNode ans = reverseLLKNodes.reverseKGroup(one, 3);
        reverseLLKNodes.printLL(ans);

    //        reverseLLKNodes.printLL(one);
    //        ListNode ans = reverseLLKNodes.reverseKGroup(one, 2);
    //        reverseLLKNodes.printLL(ans);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <=1)
            return head;

        ListNode output = head;
        while (output != null){
            if(this.root == null) {
                output = reverseBetween(head, k);
            }else {
                output = reverseBetween(this.leftBoundary.next, k);
            }

            if(this.root == null) {
                this.root = output;
            }

        }

        return this.root;


    }

    private ListNode reverseBetween(ListNode head, int k) {
//        printLL(head);
        ListNode tempHead = head;
        int initialCount = 0;
        while (tempHead != null){
            tempHead = tempHead.next;
            initialCount++;
        }

        if(initialCount < k)
            return null;

        ListNode prevLeftBoundary = this.leftBoundary;
        this.leftBoundary = head;
        ListNode newRightBoundary = head;
        int counter = 0;

        ListNode prev = null;
        while (counter<k){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            counter++;
        }

        newRightBoundary.next = head;
        if(prevLeftBoundary != null){
            prevLeftBoundary.next = prev;
        }
//        printLL(prev);
        return prev;




    }

    private void printLL(ListNode head){
        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }

        System.out.println("");

    }

}
