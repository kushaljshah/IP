package Educative.Patterns.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 * Example 3:
 *
 * Input: root = [1,2], targetSum = 0
 * Output: []
 *
 */

public class AllPathSum {

    public static void main(String[] args) {

        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(2);
        TreeNode t9 = new TreeNode(1);
        TreeNode t10 = new TreeNode(5);

        TreeNode t6 = new TreeNode(11, t7, t8);

        TreeNode t5 = new TreeNode(13);
        TreeNode t4 = new TreeNode(4,  t10, t9);

        TreeNode t1 = new TreeNode(4, t6, null);
        TreeNode t2 = new TreeNode(8, t5, t4);
        TreeNode t3 = new TreeNode(5, t1, t2);

        System.out.println(pathSum(t3, 22));


    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, targetSum, result, new ArrayList<>());
        return result;
    }

    public static void pathSum(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> entry) {
        if(root == null)
            return;

        entry.add(root.val);
        if (root.left == null && root.right == null) {
            if(targetSum - root.val == 0){
                result.add(new ArrayList<>(entry));
            }

            return;
        }

        pathSum(root.left, targetSum - root.val, result, entry);
        if(root.left != null)
            entry.remove(entry.size() - 1);

        pathSum(root.right, targetSum - root.val, result, entry);
        if(root.right != null)
            entry.remove(entry.size() - 1);

    }
}
