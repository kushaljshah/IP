package Educative.Patterns.CyclicSort;

import java.util.Arrays;

/**
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 */

public class DuplicateNumber {


    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
    }

    public static int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length){
            int j = nums[i] - 1;
            if(nums[j] != nums[i]){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }else{
                if(i == j)
                    i++;
                else
                    return nums[i];
            }
        }

        return -1;

    }

}
