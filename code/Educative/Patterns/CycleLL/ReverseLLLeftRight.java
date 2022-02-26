package Educative.Patterns.CycleLL;

/**
 *
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 *
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 *
 */


public class ReverseLLLeftRight {

    //Note: Mistakenly assumed m,n are values and not indexes. Make changes accordingly if they are indexes

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next= two;
        two.next= three;
        three.next= four;
        four.next= five;
        five.next= null;

//        reverseBetween(three, 1 , 2);
            test(one);
    }

    public static void test(ListNode head){
        printLL(head);
        int rightPosition=0;
        ListNode node = head;
        while (rightPosition <=1){
            // add conditon for last case and return null
            node = node.next;
            rightPosition++;
        }
        node.next = null;
        printLL(head);

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        printLL(head);
        if(head == null || head.next == null || left == right)
            return head;

        ListNode root = head;
        ListNode prev = null;

        ListNode leftBoundary = null;
        ListNode leftNode = null;
        ListNode rightBoundary = null;
        while (head!= null){
            ListNode next = head.next;
            if(head.val >= left && head.val <= right) {
                if(head.val == left && leftBoundary == null){
                    leftBoundary = prev;
                    leftNode = head;
                }
                if(head.val == right && rightBoundary == null){
                    rightBoundary = next;
                }


                head.next = prev;
            }

            prev = head;
            head = next;

            if(rightBoundary != null && head.val != right)
                break;
        }

        if(leftBoundary != null)
            leftBoundary.next = prev;

        if(leftNode != null)
            leftNode.next = rightBoundary;

        if(root.val == left)
            root = prev;

        printLL(root);
        return root;
    }

    private static void printLL(ListNode head){
        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }

        System.out.println("");

    }

}
