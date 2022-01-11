package Educative.Patterns.TwoPointers;

import java.util.*;

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

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
//        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
//        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));

        System.out.println(twoSumAll(new int[]{-1,0,1,2,-1,-4, 1}, 0));
        System.out.println(twoSumAll(new int[]{}, 0));
        System.out.println(twoSumAll(new int[]{0}, 0)); //Aflatoon case
        System.out.println(twoSumAll(new int[]{-3, 0, 1, 2, -1, 1, -2}, 0));
        System.out.println(twoSumAll(new int[]{-5, 2, -1, -2, 3}, 0));
        System.out.println(twoSumAll(new int[]{-2,0,0,2,2}, 0));
        System.out.println(twoSumAll(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4, 2, -2}, 0));
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, List<Integer>> input = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            input.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        Arrays.sort(nums);

        int start=0;
        int end=nums.length - 1;
        int[] result = new int[2];

        while(start <= end){
            if(nums[start] + nums[end] == target){
                if(input.get(nums[start]).size() == 0){
                    result[0] = input.get(nums[start]).get(0);
                }else{
                    result[0] = input.get(nums[start]).get(0);
                    input.get(nums[start]).remove(0);
                }

                if(input.get(nums[end]).size() == 0){
                    result[1] = input.get(nums[end]).get(0);
                }else{
                    result[1] = input.get(nums[end]).get(0);
                    input.get(nums[end]).remove(0);
                }

                break;
            }else if(nums[start] + nums[end] < target){
                start++;
            }else if(nums[start] + nums[end] > target){
                end--;
            }
        }

        return result;
    }

    public static List<List<Integer>> twoSumAll(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;

        int arrSize = nums.length;

        Arrays.sort(nums);

            int first = 0;
            int end = arrSize - 1;


            while (first < end){
                if(nums[first] + nums[end] == target){
                    List<Integer> triplet = new ArrayList<>();
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

                }else if(nums[first] + nums[end] < 0){
                    first++;
                }else {
                    end--;
                }
            }


        return result;
    }




}
