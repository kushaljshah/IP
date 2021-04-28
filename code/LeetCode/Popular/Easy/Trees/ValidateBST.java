package LeetCode.Popular.Easy.Trees;

/**
 * Created by kushal.shah
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return traverse(root, null, null);
    }

    public boolean traverse(TreeNode root, TreeNode lowerLimit,TreeNode upperLimit){
        if(root == null) return true;


        boolean leftFlag = traverse(root.left, lowerLimit, root);
        boolean rightFlag = traverse(root.right, root, upperLimit);

        if(!leftFlag || !rightFlag)
            return false;

        boolean lowerFlag = true;
        boolean upperFlag = true;

        if(lowerLimit != null){
            lowerFlag = root.val > lowerLimit.val;
        }

        if(upperLimit != null) {
            upperFlag = root.val < upperLimit.val;
        }

        return (lowerFlag && upperFlag);


    }

//    public boolean traverse(TreeNode root){
//        if(root == null) return true;
//
//        boolean lcheck = traverse(root.left);
//        boolean rcheck = traverse(root.right);
//
//        if(root.left != null){
//            if(lcheck && root.val > root.left.val)
//                lcheck = true;
//            else
//                lcheck = false;
//        }
//
//        if(root.right != null){
//            if(rcheck && root.val < root.right.val)
//                rcheck = true;
//            else
//                rcheck = false;
//        }
//
//        return lcheck && rcheck;
//
//
//    }
}
