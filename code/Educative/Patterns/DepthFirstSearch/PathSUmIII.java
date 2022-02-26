package Educative.Patterns.DepthFirstSearch;

/**
 *
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * Example 2:
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 *
 */

public class PathSUmIII {

    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {

        int sum = 0;
        myPathSum(root, sum, targetSum);
        return ans;
    }

    public void myPathSum(TreeNode root, int sum, int targetSum){

        if(root == null)
            return;

        if(root.left != null) {
            int value = 0;
            if (sum + root.val + root.left.val < targetSum)
                value = root.val;
            else if(sum + root.val + root.left.val == targetSum)
                ans++;

            myPathSum(root.left, value, targetSum);
        }

        if(root.right != null) {
            int value = 0;
            if (sum + root.val + root.right.val < targetSum)
                value = root.val;
            else if(sum + root.val + root.right.val == targetSum)
                ans++;

            myPathSum(root.right, value, targetSum);
        }


    }


}
