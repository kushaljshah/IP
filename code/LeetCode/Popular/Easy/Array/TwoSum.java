package LeetCode.Popular.Easy.Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */

public class TwoSum {
    public static int[] twoSumSorted(int[] nums, int target) {
        Arrays.sort(nums);
        int arr[] = new int[2];
        int low = 0;
        int high = nums.length - 1;
        while (low < high){
            if(nums[low] + nums[high] == target){
                arr[0] = nums[low];
                arr[1] = nums[high];
                break;
            }else if(nums[low] + nums[high] > target){
                high-- ;
            }
            else {
                low++ ;
            }
        }

        return arr;
    }



    public static void main(String[] args) {
        int[] arr = new int[3];
        arr[0] = 3;
        arr[1] = 2;
        arr[2] = 4;



    }
}
