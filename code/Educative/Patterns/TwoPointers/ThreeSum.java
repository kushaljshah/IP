package Educative.Patterns.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 */

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{}));
        System.out.println(threeSum(new int[]{0})); //Aflatoon case
        System.out.println(threeSum(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(threeSum(new int[]{-5, 2, -1, -2, 3}));
        System.out.println(threeSum(new int[]{-2,0,0,2,2}));
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;

        int arrSize = nums.length;

        Arrays.sort(nums);
        for(int i=0; i<arrSize; i++){
            if(i > 0 && nums[i] == nums[i - 1])
                continue;

            int first = i+1;
            int end = arrSize - 1;


            while (first < end){
                if(nums[i] + nums[first] + nums[end] == 0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[first]);
                    triplet.add(nums[end]);
                    result.add(triplet);
                    first++;
                    end--;

                    // ALternate tho this is sort the triplet and add. check contains next time. Complexity would be same
                    while (first < end && nums[first] == nums[first -1])
                        first++;

                    while (first < end && nums[end] == nums[end +1])
                        end--;

                }else if(nums[i] + nums[first] + nums[end] < 0){
                    first++;
                }else {
                    end--;
                }
            }
        }

        return result;
    }
}
