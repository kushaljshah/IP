package LeetCode.Popular.Easy.LinkedList;

/**
 * Created by kushal.shah
 */
public class DeleteNthNode {

    static class ListNode{
        int value;
        DeleteNthNode.ListNode next;

        public ListNode(int value){
            this.value = value;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        int count = 1;

        while (p1.next != null){
            p1 = p1.next;
            count++;
            if(count > n + 1){
                p2 = p2.next;
            }
        }

        if(count == n){
            head = head.next;
        }else{
            p2.next = p2.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        DeleteNthNode.ListNode node1 = new DeleteNthNode.ListNode(1);
        DeleteNthNode.ListNode node2 = new DeleteNthNode.ListNode(2);
        DeleteNthNode.ListNode node3 = new DeleteNthNode.ListNode(3);
        DeleteNthNode.ListNode node4 = new DeleteNthNode.ListNode(4);
        DeleteNthNode.ListNode node5 = new DeleteNthNode.ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        DeleteNthNode.ListNode current = node1;
        while (current != null){
            System.out.print(current.value);
            System.out.print("->");
            current = current.next;
        }
        System.out.println("");

        ListNode result = removeNthFromEnd(node1, 5);
        System.out.println(result.value);

        DeleteNthNode.ListNode current1 = node1;
        while (current1 != null){
            System.out.print(current1.value);
            System.out.print("->");
            current1 = current1.next;
        }
    }

}
