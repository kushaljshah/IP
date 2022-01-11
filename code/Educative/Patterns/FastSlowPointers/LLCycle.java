package Educative.Patterns.FastSlowPointers;

public class LLCycle {

    public static void main(String[] args) {

    }

    public ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;


        ListNode slow  = head;
        ListNode fast = head;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow.equals(fast))
                return cycleTermination(head, slow, fast);
        }

        return null;

    }

    public ListNode cycleTermination(ListNode head, ListNode slow, ListNode fast){
        int cycleLength = 1;
        fast = slow.next;
        while (slow != fast){
            cycleLength = cycleLength + 1;
            fast = fast.next;
        }

        slow = head;
        fast = head;

        while (cycleLength != 0){
            fast = fast.next;
            cycleLength--;
        }

        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}
