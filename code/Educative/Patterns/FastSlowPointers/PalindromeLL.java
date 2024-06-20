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
        ListNode two = new ListNode(1);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(3);
        ListNode five = new ListNode(2);
        ListNode six = new ListNode(1);
        ListNode seven = new ListNode(1);
        one.next= two;
//        two.next= three;
//        three.next= four;
//        four.next= five;
//        five.next= six;
//        six.next= seven;

        root = one;
        boolean condition = isPalindrome2(one);
        System.out.println("isPalidrome :" + condition);
    }


    public static boolean isPalindrome2(ListNode head) {

//        printLL(head);
        if(head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        // find middle node
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast =  fast.next.next;

        }


        /**
         * 1 2 3 4 5 6 7
         * 2 3
         * 3 5
         * 4 7
         *
         * 1 2 3 4 5 6
         * 2 3
         * 3 5
         * 4 6
         *
         * 1 2 3 4 5
         * 2 3
         * 3 5
         *
         * 1 2 3 4 5 6
         * 2 3
         * 3 5
         * 4 null
         *
         * a b b c b b a
         * a b b d d b b a
         *
         * p h    n
         *   1    2 3 4 5
         *       p h
         *   1    2 3 4 5
         *
         *     p h/n
         *   1 2
         *
         *       h
         *   1 2 3 4 5 6
         */

        // reverse first half
        ListNode prev = null;
        ListNode next = null;
        while (head != null && head != slow){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

//        printLL(fast);
//        printLL(slow);
//        printLL(prev);


        if(fast != null){
            /**
             * 1 2 3 4 5 6
             * a b
             *
             * 1 2 3 4 5 6 7
             * 2 3
             * 3 5
             * 4 7
             *
             * 1 2 3 4 5 6
             * 2 3
             * 3 5
             * 4 null
             *
             *
             * 1 2
             * 1 2 3
             */

            slow = slow.next;

        }else {


        }

        while (prev != null && slow != null){
            if(prev.val != slow.val)
                return false;

            prev = prev.next;
            slow = slow.next;
        }


        return true;


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
