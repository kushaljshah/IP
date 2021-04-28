package LeetCode.Popular.Easy.Trees;

/**
 * Created by kushal.shah
 */
public class MaximumDepth {
    public static int maxDepth(TreeNode root) {
        int count = 0;
//        return traverse(root, count);
        return traverse2(root);
    }

    public static int traverse(TreeNode root, int count){
        if(root == null) return count;
        count++;
        int lcount = traverse(root.left, count);
        int rcount = traverse(root.right, count);
        return Integer.max(lcount, rcount);
    }

    public static int traverse2(TreeNode root){
        if(root == null) return 0;

        int ldepth = traverse2(root.left);
        int rdepth = traverse2(root.right);
        return Integer.max(ldepth,rdepth) + 1;

    }

}
