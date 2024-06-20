package Educative.Patterns.MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * We are given a list schedule of employees, which represents the working time for each employee.
 *
 * Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
 *
 * Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.
 *
 * Example 1:
 *
 * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * Output: [[3,4]]
 * Explanation:
 * There are a total of three employees, and all common
 * free time intervals would be [-inf, 1], [3, 4], [10, inf].
 * We discard any intervals that contain inf as they aren't finite.
 *
 *
 * Example 2:
 *
 * Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 * Output: [[5,6],[7,9]]
 */
public class EmployeeFreeTime {

    public static int[][] getFreeTime(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int i=0;
        int j=0;
        int count = 0;
        int[][] result = new int[intervals.length][intervals[0].length];
        int pointer = 0;
        while (i != intervals.length && j != intervals.length){
            if(intervals[j][0] < intervals[i][1]){
                count++;
                j++;
            }else{
                count--;
                if(count == 0){
                    result[pointer] = new int[]{intervals[i][1], intervals[j][0]};
                    pointer++;
                }
                i++;

            }

        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getFreeTime(new int[][]{{1,2}, {5, 6}, {1, 3}, {4, 10}})));
//        System.out.println(Arrays.deepToString(getFreeTime(new int[][]{{1,2}, {5, 6}, {1, 3}, {4, 10}})));
//        System.out.println(Arrays.deepToString(getFreeTime(new int[][]{{1,3}, {6, 7}, {2, 4}, {2, 5}, {9, 12}})));
//        System.out.println(Arrays.deepToString(getFreeTime(new int[][]{{1,10}, {5, 6}, {1, 3}, {4, 10}})));
    }
}
