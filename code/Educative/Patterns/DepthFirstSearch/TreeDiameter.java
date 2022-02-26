package Educative.Patterns.DepthFirstSearch;

import java.util.Map;

/**
 *
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * Example 2:
 *
 * Input: root = [1,2]
 * Output: 1
 *
 */


public class TreeDiameter {

    int max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        myDiameterOfBinaryTree(root);
        return max;
    }

    public int myDiameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;

        int ldepth = root.left != null ? 1 + myDiameterOfBinaryTree(root.left) : 0;
        int rdepth = root.right != null ? 1 + myDiameterOfBinaryTree(root.left) : 0;


        if(ldepth + rdepth > max)
            max = ldepth + rdepth;


        return Integer.max(ldepth, rdepth);

    }

}
