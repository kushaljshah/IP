package Educative.Patterns.DepthFirstSearch;

/**
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * Example 2:
 *
 *
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 *
 */

public class MaximumPathSum {

    int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        sum = root.val;
        myMaxPathSum(root);
        return sum;
    }

    public int myMaxPathSum(TreeNode root) {

        if(root == null)
            return 0;

        int lSum =  myMaxPathSum(root.left);
        int rSum = myMaxPathSum(root.right);
        int localSum1 = Math.max(Math.max(root.val, root.val + lSum), root.val + rSum);
        int localSum2 = Math.max(localSum1, root.val + lSum + rSum);
        if(localSum2 > sum)
            sum = localSum2;

        return localSum1;

    }

}
