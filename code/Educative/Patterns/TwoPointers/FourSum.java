package Educative.Patterns.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */

public class FourSum {



    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 4)
            return result;

        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length-1;j++){
//                while (i < nums.length - 2 && nums[i] == nums[i+1]){
//                    i++;
//                }
//                while (j < nums.length - 2 && nums[j] == nums[j+1]){
//                    j++;
//                }

                int left = j+1;
                int right = nums.length - 1;

                ;
                while (left != right && left < nums.length - 1 && right > 0) {
//                    while (left < nums.length - 2 && nums[left] == nums[left+1]){
//                        left++;
//                    }
//                    while (right > 0 && nums[right] == nums[right-1]){
//                        right--;
//                    }

                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum > target) {
                        right--;
                    }else if(sum < target){
                        left++;
                    } else if(sum == target){
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[left]);
                        ans.add(nums[right]);
                        if(!result.contains(ans) && i!=j && j!=left && left != right)
                            result.add(ans);

                        left++;

                    }else {
                        continue;
                    }

                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(fourSum(new int[]{2,2,2,2,2}, 8));
        System.out.println(fourSum(new int[]{2,2,2,2}, 8));
        System.out.println(fourSum(new int[]{2,2,2,2}, 10));
        System.out.println(fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
//        System.out.println(fourSum(new int[]{2,2,2}, 10));
//        System.out.println(fourSum(new int[]{2,2}, 8));
//        System.out.println(fourSum(new int[]{2}, 8));
    }

}
