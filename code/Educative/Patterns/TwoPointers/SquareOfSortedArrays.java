package Educative.Patterns.TwoPointers;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */

public class SquareOfSortedArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7,-3,2,3,11})));
    }

    public static int[] sortedSquares(int[] nums) {

        int arrSize = nums.length;
        int first = 0;
        int last = arrSize -1 ;
        int[] result = new int[arrSize];

        for(int i=arrSize-1; i>=0; i--){
            if(Math.abs(nums[first]) >= Math.abs(nums[last])){
                result[i] = nums[first] * nums[first];
                first++;
            }else{
                result[i] = nums[last] * nums[last];
                last--;
            }
        }

        return result;
    }


}
