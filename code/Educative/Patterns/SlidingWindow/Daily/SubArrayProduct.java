package Educative.Patterns.SlidingWindow.Daily;

/**
 * 713. Subarray Product Less Than K
 * Medium
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 */
public class SubArrayProduct {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int windowStart = 0;
        int counter = 0;
        int product = 1;
        for (int windowEnd = 0; windowEnd<= nums.length-1; windowEnd++){
            product = product * nums[windowEnd];
            while (product >= k){
                product = product / nums[windowStart];
                windowStart++;
            }

            counter += (windowEnd - windowStart) + 1;
        }

        return counter;
    }
}
