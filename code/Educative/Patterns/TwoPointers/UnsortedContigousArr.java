package Educative.Patterns.TwoPointers;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 581. Shortest Unsorted Continuous Subarray
 * Medium
 * Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.
 *
 * Return the shortest such subarray and output its length.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 0
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 */
public class UnsortedContigousArr {
    public static int findUnsortedSubarray(int[] arr) {
        int n = arr.length;
        int lidx = Integer.MAX_VALUE;
        int ridx = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()])
                st.pop();
            if (!st.isEmpty()) {
                if (i - st.peek() > 1) {
                    lidx = Math.min(lidx, st.peek());
                    ridx = i;
                }
                else {
                    if (arr[i] < maxi)
                        ridx = i;
                    else if (arr[st.peek()] != maxi)
                        ridx = i - 1;
                }
            }
            else if (i != 0) {
                lidx = -1;
                ridx = i;
            }
            maxi = Math.max(maxi, arr[i]);
            st.push(i);
        }
        return ridx - lidx;


//        int start = 0;
//        int end = 0;
//        boolean startSetFlag = false;
//        Map<Integer, Integer> equalsFreqMap = new HashMap<>();
//        for(int i=0; i<nums.length - 1; i++){
//            if(nums[i+1] == nums[i]){
//                equalsFreqMap.put(nums[i+1],equalsFreqMap.getOrDefault(nums[i], 0) + 1);
//            }
//
//            if(nums[i + 1] < nums[i]){
//                if(!startSetFlag) {
//                    start = i - equalsFreqMap.getOrDefault(nums[i], 0);
//                    startSetFlag = true;
//                }
//
//                int tmp = nums[i+1];
//                nums[i+1] = nums[i];
//                nums[i] = tmp;
//                end = i+1;
//            }
//
//
//        }
//
////        System.out.println(start);
////        System.out.println(end);
//        return (start == 0 && end == 0) ? 0 : (end - start) + 1;
    }

    public static void main(String[] args) {
//        System.out.println(findUnsortedSubarray(new int[]{2,6,4,8,10,9,13}));
//        System.out.println(findUnsortedSubarray(new int[]{1,2,3,4}));
//        System.out.println(findUnsortedSubarray(new int[]{1}));
//        System.out.println(findUnsortedSubarray(new int[]{}));
//        System.out.println(findUnsortedSubarray(new int[]{2,6,4,8,10,11,13}));
//        System.out.println(findUnsortedSubarray(new int[]{7,6,8,10,11,13}));
//        System.out.println(findUnsortedSubarray(new int[]{5,4,3,2,1}));
//        System.out.println(findUnsortedSubarray(new int[]{1,3,2,2,2}));
//        System.out.println(findUnsortedSubarray(new int[]{1,2,3,3,3}));
        System.out.println(findUnsortedSubarray(new int[]{2,3,3,2,4}));
        System.out.println(findUnsortedSubarray(new int[]{3,2,3,2,4}));
        System.out.println(findUnsortedSubarray(new int[]{2,3,3,5,2,3,3,4}));

    }


}
