package LeetCode.Popular.Easy.LinkedList;

/**
 * Created by kushal.shah
 */
public class MergeSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr = null;
        ListNode head = null;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                if(head == null){
                    head = l1;
                }else{
                    curr.next = l1;
                }

                curr = l1;
                l1 = l1.next;
            }else{
                if(head == null){
                    head = l2;
                }else{
                    curr.next = l2;
                }

                curr = l2;
                l2 = l2.next;
            }
        }

        while (l1 != null){
            if(head == null){
                head = l1;
            }else{
                curr.next = l1;
            }

            curr = l1;
            l1 = l1.next;
        }

        while (l2 != null){
            if(head == null){
                head = l2;
            }else{
                curr.next = l2;
            }

            curr = l2;
            l2 = l2.next;
        }

        return head;
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int value){
            this.val = value;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        ListNode current = node1;
        while (current != null){
            System.out.print(current.val);
            System.out.print("->");
            current = current.next;
        }
        System.out.println("");

        ListNode current1 = node4;
        while (current1 != null){
            System.out.print(current1.val);
            System.out.print("->");
            current1 = current1.next;
        }

        System.out.println("");

        ListNode result = mergeTwoLists(node1, node4);
        ListNode current2 = result;
        while (current2 != null){
            System.out.print(current2.val);
            System.out.print("->");
            current2 = current2.next;
        }
    }


}
