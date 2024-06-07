package LeetCode.Daily.LinkedList;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 */
public class ReorderLL {

    static class ListNode{
        Integer val;
        ListNode next;

        public ListNode(Integer value){
            this.val = value;
        }
    }
    public static void reorderList(ListNode head) {

        ListNode slowNode = head;
        ListNode fastNode = head.next != null ? head.next.next : null;

        while (fastNode != null && fastNode.next != null){
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
        }

        ListNode newHead = slowNode.next;
        slowNode.next = null;

//        print(head);

        ListNode reversedHead = reverse(newHead);
        print(reversedHead);

        ListNode headCopy = head;
        ListNode prevNode = head;
        while (head!= null && reversedHead != null){
            ListNode tmp1 = head.next;
            ListNode tmp2 = reversedHead.next;
            head.next = reversedHead;
            if(head.next != null) {
                head.next.next = tmp1;
            }
            reversedHead = tmp2;
            if(head.next != null) {
                prevNode = head.next;
                head = head.next.next;

            }
        }

//        print(headCopy);

        while (reversedHead != null){
            prevNode.next = reversedHead;
            reversedHead = reversedHead.next;
        }

//        print(headCopy);


    }

    public static ListNode reverse(ListNode head) {
        ListNode prevNode = null;
        ListNode nextNode;
        ListNode currentNode = head;

        while (currentNode!= null){
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;


        }

        return prevNode;

    }

    public static void print(ListNode head){
        ListNode current1 = head;
        while (current1 != null){
            System.out.print(current1.val);
            System.out.print("->");
            current1 = current1.next;
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = null;

        reorderList(node1);
//        System.out.println(palindromeCheckUsingReverse(node1));
    }
}
