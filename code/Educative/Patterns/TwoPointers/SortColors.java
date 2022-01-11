package Educative.Patterns.TwoPointers;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Example 3:
 *
 * Input: nums = [0]
 * Output: [0]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 */


public class SortColors {

    public static void main(String[] args) {

        int[] arr1 = new int[]{2,0,2,1,1,0};
        sortColors(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[]{2,0,2,1,0,1};
        sortColors(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[]{2,0,1};
        sortColors(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = new int[]{0};
        sortColors(arr4);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = new int[]{2};
        sortColors(arr5);
        System.out.println(Arrays.toString(arr5));

        int[] arr6 = new int[]{2,2,2, 0,0, 0};
        sortColors(arr6);
        System.out.println(Arrays.toString(arr6));
    }

    public static void sortColors(int[] nums) {
        if(nums != null){
            int arrSize = nums.length;
            int start = 0;
            int end = arrSize - 1;
            int i = 0;
            while (i <= end){
                if(nums[i] == 0){
                        swap(nums, i, start);
                        start++;
                        i++;
                }else if(nums[i] == 1){
                    i++;
                }else if(nums[i] == 2){
                    swap(nums, i, end);
                    end--;
                }
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
