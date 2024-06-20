package Educative.Patterns.CycleLL;

public class RotateLinkedList {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next= null;
        two.next= three;
        three.next= four;
        four.next= five;
        five.next= null;

        RotateLinkedList rotateLinkedList = new RotateLinkedList();
        rotateLinkedList.printLL(rotateLinkedList.rotateRightNew(one, 3));

    }

    public ListNode rotateRightNew(ListNode head, int k) {
        if(head == null)
            return head;

        ListNode current = head;
        ListNode last = head;
        int size = 0;

        while (head != null){
            head = head.next;
            size++;
        }

        head = current;

        ListNode prev = null;
        if(k >= size){
            k = k%size;
        }
        int len = size-k;
        for(int i =0; i<len; i++){
            prev = head;
            head = head.next;
        }

        if(prev != null)
            prev.next = null;

        ListNode newCurrent = head;
        while (head != null && head.next!=null){
            head = head.next;
        }

        if(head!= null)
            head.next = current;
        else
            newCurrent = current;

        return newCurrent;


    }


    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;

        ListNode sizeNode = head;
        int size = 0;
        while (sizeNode != null){
            sizeNode = sizeNode.next;
            size++;
        }

        if(k%size == 0)
            return head;

        if(k > size){
            k = k % size;
        }

        int newKPosition = size - k;

        ListNode newHead = null;
        ListNode newPrev = null;
        ListNode prev = null;
        ListNode curr = head;
        int counter = 0;

        while (curr != null){
            if(counter == newKPosition) {
                newHead = curr;
                newPrev = prev;
            }


            prev = curr;
            curr = curr.next;
            counter++;
        }

        newPrev.next = null;
        prev.next = head;


        return newHead;


    }

    private void printLL(ListNode head){
        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }

        System.out.println("");

    }


}
