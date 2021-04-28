package LeetCode.Popular.Easy.LinkedList;

/**
 * Created by kushal.shah
 */
public class DeleteNode {

    static class ListNode{
        int value;
        ListNode next;

        public ListNode(int value){
            this.value = value;
        }


    }

    public static void deleteNode(ListNode node) {
        if(node.next != null){
            node.value = node.next.value;
            node.next = node.next.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode current = node1;
        while (current != null){
            System.out.print(current.value);
            System.out.print("->");
            current = current.next;
        }
        System.out.println("");


        deleteNode(node3);

        ListNode current1 = node1;
        while (current1 != null){
            System.out.print(current1.value);
            System.out.print("->");
            current1 = current1.next;
        }





    }
}
