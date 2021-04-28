package LeetCode.Popular.Easy.LinkedList;

/**
 * Created by kushal.shah
 */
public class DetectCycle {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(Integer value){
            this.val = value;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        System.out.println(hasCycle(node1));

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast.next != null){
            if(slow == fast){
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
