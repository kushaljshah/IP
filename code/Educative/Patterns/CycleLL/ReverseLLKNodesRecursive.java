package Educative.Patterns.CycleLL;

/**
 *
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 *
 * Imp: In tyhis solution the case for remaining nodes with size less than k doesn't work
 *
 */











class ReverseLLKNodesRecursive {

    public static class Node {
        int data;
        Node next;

        Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }

        // Helper function to print linked list starting from the current node
        public void print()
        {
            Node ptr = this;
            while (ptr != null)
            {
                System.out.print(ptr.data + " —> ");
                ptr = ptr.next;
            }
            System.out.println("null");
        }
    }
    public static Node reverseKGroupNew(Node head, int k) {

        if(head == null)
            return null;

        int size =0;
        Node initialHead = head;
        while (head!= null){
            head = head.next;
            size++;
        }

        head = initialHead;

        Node prev = null;
        Node preHead = null;
        for(int i=0; i<size/k;i++) {
            if(prev == null) {
                prev = reverse(head, k);
            }else {
                preHead.next = reverse(head,k);
            }
            preHead = head;
            prev.print();
            head = head.next;
        }

        return prev;
    }

    public static Node reverse(Node head, int k){
        Node prev = null;
        int nodeCounter = 0;

        Node originalHead = head;
        while (head != null){
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            nodeCounter++;
            if(nodeCounter == k)
                break;

        }

        originalHead.next = head;
        return prev;
    }

    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8};

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        Node res = reverseInGroups(head, 3);
        res.print();
    }

    // Function to reverse every group of `k` nodes in a given linked list
    public static Node reverseInGroups(Node head, int k)
    {
        // base case
        if (head == null) {
            return null;
        }

        // start with the current node
        Node current = head;

        // reverse next `k` nodes
        Node prev = null;
        int count = 0;

        // iterate through the list and move/insert each node
        // in front of the result list (like a push of the node)
        while (current != null && count++ < k)
        {
            // tricky: note the next node
            Node next = current.next;

            // move the current node onto the result
            current.next = prev;

            // update the previous pointer to the current node
            prev = current;

            // move to the next node in the list
            current = next;
        }

        // recur for remaining nodes
        head.next = reverseInGroups(current, k);

        // it is important to return the previous node
        // (to link every group of `k` nodes)
        return prev;
    }


}
