package Educative.Patterns.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
        next = null;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class NextRightPointer {

    public static void main(String[] args) {
        Node n1 = new Node(6);
        Node n2 = new Node(7);

        Node node1 = new Node(4);
        Node node2 = new Node(5);
        Node node3 = new Node(3, n1, n2);
        Node node4 = new Node(2, node1, node2);
        Node node5 = new Node(1, node4, node3);

        System.out.println(new NextRightPointer().connect(node5));
    }

    public Node connect(Node root) {
        
        Queue<Node> queue = new LinkedList<>();

        if(root == null)
            return root;

        queue.add(root);

        while (queue.size() != 0){
            int size = queue.size();
            for(int i = 1; i<=size; i++){
                Node node = queue.remove();
                if(queue.peek() != null && i < size)
                    node.next = queue.peek();
                else
                    node.next = null;

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }

            }

        }

        return root;

    }

}
