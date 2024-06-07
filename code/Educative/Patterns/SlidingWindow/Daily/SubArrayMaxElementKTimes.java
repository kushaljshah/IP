package Educative.Patterns.SlidingWindow.Daily;

import java.util.*;

/**
 *2962. Count Subarrays Where Max Element Appears at Least K Times
 * Medium
 * You are given an integer array nums and a positive integer k.
 *
 * Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
 *
 * A subarray is a contiguous sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,2,3,3], k = 2
 * Output: 6
 * Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
 * Example 2:
 *
 * Input: nums = [1,4,2,1], k = 3
 * Output: 0
 * Explanation: No subarray contains the element 4 at least 3 times.
 */
public class SubArrayMaxElementKTimes {

    public static long countSubarrays(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        int start = 0;
        int counter = 0;
        long result = 0;
        for (int end=0; end<nums.length; end++){
            if(nums[end] == maxElement) {
                counter++;
            }

            while (counter == k){
                if(nums[start] == maxElement){
                    counter--;
                }
                start++;
            }

            result = result + start;


        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,3,2,3,3}, 2));
        System.out.println(countSubarrays(new int[]{1,4,2,1}, 3));
        System.out.println(countSubarrays(new int[]{4,3,7,10,2,10,1,6,10,7,10,10,10}, 3));
        System.out.println(countSubarrays(new int[]{21,11,13,15,16,21,8,9,6,21}, 2));

    }

}
