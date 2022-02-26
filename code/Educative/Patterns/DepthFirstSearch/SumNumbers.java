package Educative.Patterns.DepthFirstSearch;

/**
 *
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A leaf node is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 *
 * Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 *
 */

public class SumNumbers {

    int sum = 0;
    int path = 0;

    public static void main(String[] args) {
        TreeNode t2Left = new TreeNode(5);
        TreeNode t2Right = new TreeNode(1);

        TreeNode t1Left = new TreeNode(9, t2Left, t2Right);
        TreeNode t1Right = new TreeNode(0);


        TreeNode t1 = new TreeNode(4, t1Left, t1Right);

        SumNumbers sn = new SumNumbers();
        System.out.println(sn.sumNumbers(t1));


    }

    public int sumNumbers(TreeNode root) {
        mySumNumbers(root);
        return sum;

    }

    public void mySumNumbers(TreeNode root){

        if(root == null)
            return;

        path = getPathVal(path, root, true);

        if(root.left == null && root.right == null) {
            sum = sum + path;
            return;
        }


        mySumNumbers(root.left);
        path = getPathVal(path, root.left, false);
        mySumNumbers(root.right);
        path = getPathVal(path, root.right, false);


    }

    public int getPathVal(int path, TreeNode treeNode, boolean flag) {
        if (treeNode != null) {
            int val = treeNode.val;
            if (flag) {
                if (path == 0)
                    return val;
                else {
                    return (path * 10) + val;
                }
            } else {
                return (path - val) / 10;
            }
        }else {
            return path;
        }
    }

}
