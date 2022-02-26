package Educative.Patterns.BreadthFirstSearch;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * Example 2:
 *
 *
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 *
 */

public class AverageLevelOrderTraversal {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null)
            return result;

        queue.add(root);

        while (queue.size() != 0){
            Double levelSize = 0.0;
            Double levelSum = 0.0;
            int size = queue.size();
            for(int i = 0; i<size; i++){
                TreeNode node = queue.remove();
                levelSum = levelSum + (double) node.val;
                levelSize++;

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }

            }
            result.add(levelSum/levelSize);
        }

        return result;
    }

}
