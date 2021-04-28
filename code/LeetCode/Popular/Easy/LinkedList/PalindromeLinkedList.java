package LeetCode.Popular.Easy.LinkedList;

/**
 * Created by kushal.shah
 */
public class PalindromeLinkedList {

    static class ListNode{
        Integer val;
        ListNode next;

        public ListNode(Integer value){
            this.val = value;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        System.out.println(palindromeCheckUsingRecursion(node1));
//        System.out.println(palindromeCheckUsingReverse(node1));
    }

    public static boolean palindromeCheckUsingReverse(ListNode head){
        //Get size of linkedlist
        ListNode sizeHead = head;
        int size = 0;
        while (sizeHead != null){
            size = size + 1;
            sizeHead = sizeHead.next;
        }

        System.out.println("size: "+ size);
        int middle = (size%2 == 0) ? size/2 : (size/2) + 1;
        System.out.println("middle: "+ middle);

        // reverse second half
        ListNode reverseHead = head;
        int count = 0;
        ListNode newReversedHead = null;
        while (reverseHead != null){
            count++;
            reverseHead = reverseHead.next;
            if(count == middle){
                newReversedHead = reverseLL(reverseHead);
                break;
            }
        }

        ListNode current1 = newReversedHead;
        while (current1 != null){
            System.out.print(current1.val);
            System.out.print("->");
            current1 = current1.next;
        }
        System.out.println("");

        // palindromic check first half and second half
        boolean flag = false;
        while (newReversedHead != null){
            if(head.val.equals(newReversedHead.val)){
                flag = true;
            }else{
                flag = false;
                break;
            }

            newReversedHead = newReversedHead.next;
            head = head.next;
        }


        return flag;
    }

    public static ListNode reverseLL(ListNode head){
        if(head.next == null) return head;

        ListNode backNode = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return backNode;
    }

    public static boolean palindromeCheckUsingRecursion(ListNode head){
        if(head == null)
            return false;
        return palindromeCheckUsingRecursionUtil(head, head);
    }

    public static boolean palindromeCheckUsingRecursionUtil(ListNode left, ListNode right){
        if(right == null)
            return true;

        boolean flag = palindromeCheckUsingRecursionUtil(left, right.next);
        if(!flag)
            return false;
        flag = (left.val.equals(right.val));
        if(left.next != null) {
            left.val = left.next.val;
            left.next = left.next.next;
        }
        return flag;

    }

}
