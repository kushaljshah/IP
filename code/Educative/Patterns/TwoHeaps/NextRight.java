package Educative.Patterns.TwoHeaps;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.
 *
 * The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.
 *
 * Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,2]]
 * Output: [-1]
 * Explanation: There is only one interval in the collection, so it outputs -1.
 * Example 2:
 *
 * Input: intervals = [[3,4],[2,3],[1,2]]
 * Output: [-1,0,1]
 * Explanation: There is no right interval for [3,4].
 * The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
 * The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
 * Example 3:
 *
 * Input: intervals = [[1,4],[2,3],[3,4]]
 * Output: [-1,2,-1]
 * Explanation: There is no right interval for [1,4] and [3,4].
 * The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
 *
 */

public class NextRight {



    public static void main(String[] args) {

    }

//    public int[] findRightInterval(int[][] intervals) {
////        PriorityQueue<Integer> p1 = new PriorityQueue<>();
////        PriorityQueue<Integer> p2 = new PriorityQueue<>();
////
////        HashMap<Integer, Integer> firstIndexToPosMap = new HashMap<>();
////        HashMap<Integer, Integer> firstIndexToSecondIndexMap = new HashMap<>();
////
////        for(int i=0; i<intervals.length; i++){
////            p1.add(intervals[i][0]);
////            p2.add(intervals[i][1);
////            firstIndexToPosMap.put(intervals[i][0], i);
////            firstIndexToSecondIndexMap.put(intervals[i][0], intervals[i][1]);
//
//        }

//        while (!p1.isEmpty()){
//            int first = p1.remove();
//
//        }






    }

