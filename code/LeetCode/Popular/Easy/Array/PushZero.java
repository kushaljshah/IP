package LeetCode.Popular.Easy.Array;

import java.io.*;
import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */

class PushZero
{
    public static void moveZeroes(int[] nums) {
        for(int i=0,j=0; i<nums.length;i++){
            if(nums[i] != 0){
                swap(nums,i,j);
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[10];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 0;
        nums[3] = 3;
        nums[4] = 12;

        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int x, int y){
        int num1 = nums[x];
        int num2 = nums[y];

        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;

        nums[x] = num1;
        nums[y] = num2;
    }

}
