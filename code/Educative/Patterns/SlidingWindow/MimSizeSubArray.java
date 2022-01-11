package Educative.Patterns.SlidingWindow;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is  equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 */

public class MimSizeSubArray {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if(target == 0 || nums == null || nums.length == 0 )
            return 0;

        int sum = 0;
        int firstIndex = 0;
        int max = 0;

        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
            while (sum > target){
                sum = sum - nums[firstIndex];
                firstIndex++;
            }

            if(sum == target) {
                 if(((i - firstIndex) + 1) < max || max == 0)
                     max = (i - firstIndex) + 1;
            }
        }

        return max;
    }

}
