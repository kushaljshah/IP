package LeetCode.Daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length == 0) {
            intervals = new int[1][2];
            intervals[0] = newInterval;
        }


        int[][] result = new int[intervals.length+1][intervals[0].length];

        int newIntervalStart = newInterval[0];
        int newIntervalEnd = newInterval[1];

        int mergedIntervalStart = intervals[0][0];
        int mergedIntervalEnd = intervals[0][1];;
        int resultCounter = 0;
        int previousMergedInterValStart = -1;
        int previousMergedInterValEnd = -1;
        boolean isIntervalMerged = false;

        if(isNewSlotSmallest(intervals[0][0], intervals[0][1], newIntervalStart, newIntervalEnd)){
            result[resultCounter] = newInterval;
            resultCounter++;
            isIntervalMerged = true;
        }

        for(int i=0; i<intervals.length; i++){
            int intervalStart = intervals[i][0];
            int intervalEnd = intervals[i][1];

            if(isNumberInMiddle(intervalStart, intervalEnd, newIntervalStart) ||
                    isNumberInMiddle(intervalStart, intervalEnd, newIntervalEnd) ||
                    (isNumberInMiddle(newIntervalStart, newIntervalEnd, intervalStart) && isNumberInMiddle(newIntervalStart, newIntervalEnd, intervalEnd))
            ){
                mergedIntervalStart = Math.min(intervalStart, newIntervalStart);
                mergedIntervalEnd = Math.max(intervalEnd, newIntervalEnd);

                if(isPreviousOverlapping(previousMergedInterValStart, previousMergedInterValEnd, mergedIntervalStart, mergedIntervalEnd)){
                    int counter = Math.max(resultCounter - 1, 0);
                    mergedIntervalStart = Math.min(previousMergedInterValStart, mergedIntervalStart);
                    mergedIntervalEnd = Math.max(previousMergedInterValEnd, mergedIntervalEnd);
                    result[counter][0] = mergedIntervalStart;
                    result[counter][1] = mergedIntervalEnd;
                }else {
                    result[resultCounter][0] = mergedIntervalStart;
                    result[resultCounter][1] = mergedIntervalEnd;
                    resultCounter++;
                }

                previousMergedInterValStart = mergedIntervalStart;
                previousMergedInterValEnd = mergedIntervalEnd;
                isIntervalMerged = true;

            } else{

                mergedIntervalStart = intervalStart;
                mergedIntervalEnd = intervalEnd;

                result[resultCounter] = intervals[i];
                resultCounter++;

            }
        }

        if(isNewSlotLargest(mergedIntervalStart, mergedIntervalEnd, newIntervalStart, newIntervalEnd)){
            result[resultCounter] = newInterval;
            resultCounter++;
            isIntervalMerged = true;
        }

        int[][] finalResult;
        if(isIntervalMerged)
            finalResult = new int[resultCounter][2];
        else
            finalResult = new int[resultCounter+1][2];

        int j = 0;
        int i = 0;
        for(int k=0; k<finalResult.length; k++){
            if(isIntervalMerged) {
                finalResult[j] = result[i];
                j++;
                i++;
            }
            else {
                if(i>0 && newInterval[0] > result[i-1][0] && newInterval[0] < result[i][0]) {
                    finalResult[j] = newInterval;
                    isIntervalMerged = true;
                    j++;
                }else {
                    finalResult[j] = result[i];
                    j++;
                    i++;
                }
            }
        }

        return finalResult;

    }

    public boolean isNewSlotSmallest(int start, int end, int newStart, int newEnd){
        return newStart < start && newEnd < start;
    }
    public boolean isNewSlotLargest(int start, int end, int newStart, int newEnd){
        return newStart > end && newEnd > end;
    }

    public boolean isNumberInMiddle(int start, int end, int middle){
        return middle >= start && middle <= end;
    }

    public boolean isPreviousOverlapping(int prevStart, int prevEnd, int newStart, int newEnd){
        return isNumberInMiddle(prevStart, prevEnd, newStart) || isNumberInMiddle(prevStart, prevEnd, newEnd);
    }


    public static void main(String[] args) {
        InsertInterval ii = new InsertInterval();
        int[][] input1 = {{1,3}, {6,9}};
        int[] interval1 = {2,5};

        System.out.println(Arrays.deepToString(ii.insert(input1, interval1)));

        int[][] input2 = {{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int[] interval2 = {4,8};

        System.out.println(Arrays.deepToString(ii.insert(input2, interval2)));

        int[][] input3 = {};
        int[] interval3 = {4,8};

        System.out.println(Arrays.deepToString(ii.insert(input3, interval3)));

        int[][] input4 = {{3,5}, {6,7}, {8,10}, {12,16}};
        int[] interval4 = {18,20};

        System.out.println(Arrays.deepToString(ii.insert(input4, interval4)));

        int[][] input5 = {{3,5}, {6,7}, {8,10}, {12,16}};
        int[] interval5 = {1,2};

        System.out.println(Arrays.deepToString(ii.insert(input5, interval5)));

        int[][] input6 = {{1,2}, {3,5}, {6,7}, {8,10}};
        int[] interval6 = {2,9};

        System.out.println(Arrays.deepToString(ii.insert(input6, interval6)));

        int[][] input7 = {{1,3}, {6,9}};
        int[] interval7 = {4,7};

        System.out.println(Arrays.deepToString(ii.insert(input7, interval7)));

        int[][] input8 = {{1,3}, {6,9}};
        int[] interval8 = {3,6};

        System.out.println(Arrays.deepToString(ii.insert(input8, interval8)));

        int[][] input9 = {{3,5}, {12,15}};
        int[] interval9 = {6,6};

        System.out.println(Arrays.deepToString(ii.insert(input9, interval9)));

        int[][] input10 = {{6,10},{13,16},{19,19},{23,25},{34,39},{41,43},{49,51}};
        int[] interval10 = {27,27};

        System.out.println(Arrays.deepToString(ii.insert(input10, interval10)));

        /**
         * [[1, 5], [6, 9]]
         * [[1, 2], [3, 10], [12, 16]]
         * [[4, 8]]
         * [[3, 5], [6, 7], [8, 10], [12, 16], [18, 20]]
         * [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]]
         * [[1, 10]]
         * [[1, 3], [4, 9]]
         * [[1, 9]]
         * [[3, 5], [6, 6], [12, 15]]
         * [[6, 10], [13, 16], [19, 19], [23, 25], [27, 27], [34, 39], [41, 43], [49, 51]]
         */

    }

    /** Ideal Solve
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int n = intervals.length, i = 0;
            List<int[]> res = new ArrayList<>();

            // Case 1: No overlapping before merging intervals
            while (i < n && intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
                i++;
            }

            // Case 2: Overlapping and merging intervals
            while (i < n && newInterval[1] >= intervals[i][0]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
            res.add(newInterval);

            // Case 3: No overlapping after merging newInterval
            while (i < n) {
                res.add(intervals[i]);
                i++;
            }

            // Convert List to array
            return res.toArray(new int[res.size()][]);
        }
    }

     **/

}
