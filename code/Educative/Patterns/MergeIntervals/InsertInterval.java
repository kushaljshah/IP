package Educative.Patterns.MergeIntervals;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
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
 *
 */

public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{};
        int[] newInterval = new int[]{0, 1};

        System.out.println(insert(intervals, newInterval));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length+1][];
        int x = newInterval[0];
        int low = 0;
        int high = intervals.length - 1 >= 0 ? intervals.length - 1 : 0;

        if(intervals.length == 0)
            return new int[][]{newInterval};

        while (low < high){
            int mid = low + (high - low)/2;

            if(x <= intervals[mid][0]){
                high = mid - 1;
            }else if(x > intervals[mid][0]){
                low = mid + 1;
            }
        }

        if(high < 0)
            high = 0;

        if(low > intervals.length - 1)
            low = intervals.length - 1;


        int j = 0;
        for(int i=0; i< intervals.length; i++){
            if(i==high){
                if(newInterval[0] < intervals[high][0]) {
                    result[j] = newInterval;
                    j++;
                    result[j] = intervals[i];
                    j++;
                }else{
                    result[j] = intervals[i];
                    j++;
                    result[j] = newInterval;
                    j++;
                }
            }else{
                result[j] = intervals[i];
                j++;
            }
        }

        return merge(result);


    }

    public static int[][] merge(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();
        for(int[] interval: intervals){
            if(result.isEmpty() || interval[0] > result.getLast()[1]) {
                result.add(interval);
            }else{
                int x = result.getLast()[0];
                int y = Math.max(result.getLast()[1], interval[1]);
                result.remove(result.getLast());
                result.add(new int[]{x, y});
            }
        }

        return result.toArray(new int[result.size()][]);

    }

}
