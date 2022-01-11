package Educative.Patterns.FastSlowPointers;

// Java program to detect loop in a linked list
import java.util.*;

class GFG{

    // Link list node
    static class Node
    {
        int data;
        Node next;
        int flag;
    };

    static Node push(Node head_ref, int new_data)
    {

        // Allocate node
        Node new_node = new Node();

        // Put in the data
        new_node.data = new_data;

        new_node.flag = 0;

        // Link the old list off the new node
        new_node.next = head_ref;

        // Move the head to point to the new node
        head_ref = new_node;
        return head_ref;
    }

    // Returns true if there is a loop in linked
// list else returns false.
    static Node detectLoop(Node head)
    {
        if (head == null || head.next == null)
            return null;


        Node slow  = head;
        Node fast = head;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow.equals(fast))
                return cycleTermination(head, slow, fast);
        }

        return null;
    }

    public static Node cycleTermination(Node head, Node slow, Node fast){
        int cycleLength = 1;
        fast = slow.next;
        while (slow != fast){
            cycleLength = cycleLength + 1;
            fast = fast.next;
        }

        System.out.println(cycleLength);

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

        System.out.println(slow.data);


        return null;

    }

    // Driver code
    public static void main(String[] args)
    {

        // Start with the empty list
        Node head = null;

        head = push(head, 20);
        head = push(head, 4);
        head = push(head, 15);
        head = push(head, 10);

        // Create a loop for testing
        head.next.next.next.next = head;

        System.out.println(detectLoop(head));
    }
}
