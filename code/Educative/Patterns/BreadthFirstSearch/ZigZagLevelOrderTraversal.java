package Educative.Patterns.BreadthFirstSearch;

import java.util.*;

/**
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 */


public class ZigZagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3, null, node2);
        TreeNode node4 = new TreeNode(2, node1, null);
        TreeNode node5 = new TreeNode(1, node4, node3);

        System.out.println(new ZigZagLevelOrderTraversal().zigzagLevelOrder(node5));
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null)
            return result;

        queue.add(root);
        int level = 1;

        while (queue.size() != 0){
            List<Integer> levelNodes = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i<size; i++){
                TreeNode node = queue.remove();
                levelNodes.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(level % 2 == 0)
                Collections.reverse(levelNodes);
            result.add(levelNodes);
            level++;
        }

        return result;
    }

}
