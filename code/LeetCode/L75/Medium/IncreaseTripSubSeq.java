package LeetCode.L75.Medium;

/**
 *
 334. Increasing Triplet Subsequence
 Medium
 Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.



 Example 1:

 Input: nums = [1,2,3,4,5]
 Output: true
 Explanation: Any triplet where i < j < k is valid.
 Example 2:

 Input: nums = [5,4,3,2,1]
 Output: false
 Explanation: No triplet exists.
 Example 3:

 Input: nums = [2,1,5,0,4,6]
 Output: true
 Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 */
public class IncreaseTripSubSeq {
    public boolean increasingTriplet(int[] nums) {
        int first_small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < first_small)
                first_small = nums[i];
            else if(nums[i] < second_small)
                second_small = nums[i];
            else
                return true;
        }

        return false;
    }

    /**
     * As a continuation to this problem following program should also be checked
     * https://www.geeksforgeeks.org/count-of-triplets-whose-indices-and-element-at-that-indices-are-in-increasing-order/
     * https://www.geeksforgeeks.org/print-all-triplets-with-given-sum/
     */
}
