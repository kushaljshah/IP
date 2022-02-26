package Educative.Patterns.DepthFirstSearch;

/**
 *
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
A leaf is a node with no children.
 *
 *
 *
Example 1:
 *
 *
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:
 *
 *
Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:
 *
Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
 *
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PathSum {

    public static void main(String[] args) {

        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(2);
        TreeNode t9 = new TreeNode(1);

        TreeNode t6 = new TreeNode(11, t7, t8);

        TreeNode t5 = new TreeNode(13);
        TreeNode t4 = new TreeNode(4,  null, t9);

        TreeNode t1 = new TreeNode(4, t6, null);
        TreeNode t2 = new TreeNode(8, t5, t4);
        TreeNode t3 = new TreeNode(5, t1, t2);

        System.out.println(hasPathSum(t3, 22));


    }


    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;

        if (targetSum - root.val == 0 && root.left == null && root.right == null)
            return true;


        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);

        return left || right;

    }



}
