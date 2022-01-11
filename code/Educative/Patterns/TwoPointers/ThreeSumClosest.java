package Educative.Patterns.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 */

public class ThreeSumClosest {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(threeSumClosest(new int[]{0,0,0}, 1));
        System.out.println(threeSumClosest(new int[]{1,1,1, 0}, -100));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int arrSize = nums.length;

        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int sum = 0;
        int result = 0;
        for(int i=0; i<arrSize; i++){

            int first = i+1;
            int end = arrSize - 1;
            while (first < end) {
                sum = nums[i] + nums[first] + nums[end];
                int sumDIff = Math.abs(sum - target);

                if (sumDIff < minDiff) {
                    minDiff = sumDIff;
                    result = sum;
                }

                if (sum == target){
                  return sum;
                } else if(sum < target) {
                    first++;
                } else {
                    end--;
                }
            }
        }

        return result;
    }

}
