package Educative.Patterns.TwoHeaps;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle values.
 *
 * For examples, if arr = [2,3,4], the median is 3.
 * For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
 * You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the median array for each window in the original array. Answers within 10-5 of the actual value will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
 * Explanation:
 * Window position                Median
 * ---------------                -----
 * [1  3  -1] -3  5  3  6  7        1
 *  1 [3  -1  -3] 5  3  6  7       -1
 *  1  3 [-1  -3  5] 3  6  7       -1
 *  1  3  -1 [-3  5  3] 6  7        3
 *  1  3  -1  -3 [5  3  6] 7        5
 *  1  3  -1  -3  5 [3  6  7]       6
 * Example 2:
 *
 * Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
 * Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
 *
 */


public class SlidingWindowMedian {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());


    public static void main(String[] args) {

    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - (k -1)];

        int start = 0;
//        int end = 0;
        for(int i=0; i<nums.length; i++) {
//            end = i;

            if (maxHeap.isEmpty() || nums[i] <= maxHeap.peek()){
                maxHeap.add(nums[i]);
            }else{
                minHeap.add(nums[i]);
            }

            if(maxHeap.size() - minHeap.size() > 1){
                minHeap.add(maxHeap.remove());
            }

            if(minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.remove());
            }

            if(i >= (k-1)){
                ans[start] = findMedian();
                if(maxHeap.contains(nums[start])){
                    maxHeap.remove(nums[start]);
                }else {
                    minHeap.remove(nums[start]);
                }

                start++;
            }
        }

        return ans;
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size())
            return ((double)maxHeap.peek() + (double)minHeap.peek())/2.0;
        else
            return maxHeap.peek();
    }

}
