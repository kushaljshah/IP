package Educative.Patterns.FastSlowPointers;

import java.util.List;

/**
 *
 * Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
 *
 * Your algorithm should use constant space and the input LinkedList should be in the original form once the algorithm is finished. The algorithm should have O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.
 *
 * Example 1:
 * Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
 * Output: true
 * Example 2:
 * Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null
 * Output: false
 *
 *
 * https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
 *
 */


public class PalindromeLL {

    static ListNode root;

    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(3);
        ListNode six = new ListNode(2);
        ListNode seven = new ListNode(1);
        one.next= two;
        two.next= three;
        three.next= four;
        four.next= five;
        five.next= six;
        six.next= seven;

        root = one;
        boolean condition = isPalindromeRec(one);
        System.out.println("isPalidrome :" + condition);
    }

    public static boolean isPalindrome(ListNode head) {

        printLL(head);
        if(head == null || head.next == null)
            return true;

        //find the middle of the node
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null){
            slow = slow.next;
        }

        ListNode curr = slow;
        ListNode prev = null;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        printLL(head);
        printLL(prev);

        while (head != null && prev != null){
            if(head.val != prev.val)
                return false;

            head = head.next;
            prev = prev.next;
        }



        return true;

    }

    public static boolean isPalindromeRec(ListNode curr){

        if(curr == null)
            return true;
        else{
            boolean res = isPalindromeRec(curr.next);
            if(res){
                boolean match = false;
                if(root.val == curr.val){
                    match = true;
                }
                root = root.next;
                return match;
            }else{
                return false;
            }
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
