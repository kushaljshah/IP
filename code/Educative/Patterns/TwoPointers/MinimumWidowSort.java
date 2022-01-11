package Educative.Patterns.TwoPointers;

/**
 * Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements in arr are non-decreasing.
 *
 * Return the length of the shortest subarray to remove.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,10,4,2,3,5]
 * Output: 3
 * Explanation: The shortest subarray we can remove is [10,4,2] of length 3. The remaining elements after that will be [1,2,3,3,5] which are sorted.
 * Another correct solution is to remove the subarray [3,10,4].
 * Example 2:
 *
 * Input: arr = [5,4,3,2,1]
 * Output: 4
 * Explanation: Since the array is strictly decreasing, we can only keep a single element. Therefore we need to remove a subarray of length 4, either [5,4,3,2] or [4,3,2,1].
 * Example 3:
 *
 * Input: arr = [1,2,3]
 * Output: 0
 * Explanation: The array is already non-decreasing. We do not need to remove any elements.
 * Example 4:
 *
 * Input: arr = [1]
 * Output: 0
 */

public class MinimumWidowSort {

    public static void main(String[] args) {
        System.out.println(findLengthOfShortestSubarray(new int[]{1,2}));
        System.out.println(findLengthOfShortestSubarray(new int[]{1}));
        System.out.println(findLengthOfShortestSubarray(new int[]{1,2,3,4,5}));
        System.out.println(findLengthOfShortestSubarray(new int[]{5,4,3,2,1}));
        System.out.println(findLengthOfShortestSubarray(new int[]{1,2,3}));
        System.out.println(findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5}));
        System.out.println(findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,4,5,6}));
        System.out.println(findLengthOfShortestSubarray(new int[]{13,0,14,7,18,18,18,16,8,15,20}));
        System.out.println(findLengthOfShortestSubarray(new int[]{1,2,3,3,10,1,3,3,5}));
        System.out.println(findLengthOfShortestSubarray(new int[]{10,13,17,21,15,15,9,17,22,22,13}));
    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        int left=0;
        int length = arr.length;
        int endIndex = length - 1;
        int right= length - 1;
        int minLength = Integer.MAX_VALUE;

        if(arr.length <= 1)
            return 0;

        while (left<right && arr[left] <= arr[left + 1]){
            left++;
        }

        if(left == right)
            return 0;

        if(endIndex - left < minLength)
            minLength = endIndex - left;

        while (right > left && arr[right] >= arr[right - 1])
            right--;


        if(right < minLength)
            minLength = right;

//        1,2,3,10,4,2,3,5
        for(int i=0; i<=left; i++){
            if (right < arr.length && arr[i] <= arr[right]){
                if(right - i - 1 < minLength)
                    minLength = (right - i - 1);
            }else{
                right++;
            }
        }

        return minLength;


    }



}
