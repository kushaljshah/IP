package Educative.Patterns.BreadthFirstSearch;

import java.util.*;

/**
 *
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[15,7],[9,20],[3]]
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


public class ReverseLevelOrderTraversal {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

        Collections.reverse(result);
        return result;
    }


    public List<List<Integer>> levelOrderBottomWithoutReverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        // Important
        Deque<List<Integer>> deque = new LinkedList<>();
        int l;

        queue.offer(root);
        if(root==null){
            return (List)deque;
        }
        TreeNode curr;
        while(!queue.isEmpty()){
            l = queue.size();
            List<Integer> currLevel = new LinkedList<>();
            while(l>0){
                curr = queue.poll();
                currLevel.add(curr.val);
                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                }
                l--;
            }
            deque.offerFirst(currLevel);
        }
        return (List)deque;
    }
}
