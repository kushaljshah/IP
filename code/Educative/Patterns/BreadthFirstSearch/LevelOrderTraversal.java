package Educative.Patterns.BreadthFirstSearch;

import java.util.*;

/**
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
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


public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(15);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(20, node1, node2);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(3, node4, node3);

        System.out.println(new LevelOrderTraversal().levelOrder(node5));
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null)
            return result;

        queue.add(root);

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
            result.add(levelNodes);
        }

        return result;

    }




}
