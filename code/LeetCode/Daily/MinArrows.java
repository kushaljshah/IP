package LeetCode.Daily;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
 *
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 *
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 * Example 2:
 *
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * Output: 4
 * Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
 * Example 3:
 *
 * Input: points = [[1,2],[2,3],[3,4],[4,5]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
 * - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
 */

public class MinArrows {


    /**
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        quicksort(points, 0, points.length - 1);

        int cnt = 0;
        int prevEnd = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; ++i) {
            int[] curr = points[i];
            int currStart = curr[0];
            int currEnd = curr[1];
            if (currStart <= prevEnd) {
                prevEnd = Math.min(currEnd, prevEnd);
            } else {
                ++cnt;
                prevEnd = currEnd;
            }
        }

        return cnt + 1;
    }
     **/

    public Boolean IS_OVERLAP = false;
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int arrowCount = 1;
        int i=0;
        int pointStart = points[i][0];
        int pointEnd = points[i][1];
        while(i < points.length){
            if(i+1< points.length) {
                int nextPointStart = points[i + 1][0];
                int nextPointEnd = points[i+1][1];
                IS_OVERLAP = false;
                int[] overLapPoint = findOverLap(pointStart, pointEnd, nextPointStart, nextPointEnd);
                if(IS_OVERLAP){
                    i++;
                    pointStart = overLapPoint[0];
                    pointEnd = overLapPoint[1];
                }else {
                    arrowCount++;
                    pointStart = nextPointStart;
                    pointEnd = nextPointEnd;
                    i++;
                }
                continue;
            }else {
                i++;
            }


        }

        return arrowCount;

    }

    public int[] findOverLap(int pointStart, int pointEnd, int nextPointStart, int nextPointEnd){
        IS_OVERLAP = false;
        int[] overLapPoint = new int[2];
        if(nextPointStart >= pointStart && nextPointStart <= pointEnd){
            IS_OVERLAP = true;
            overLapPoint[0] = nextPointStart;
            overLapPoint[1] = Math.min(pointEnd, nextPointEnd);
        }

        return overLapPoint;
    }

    public static void main(String[] args) {
        MinArrows minArrows = new MinArrows();
        int[][] input1 = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(minArrows.findMinArrowShots(input1) == 2);

        int[][] input2 = {{1,2},{3,4},{5,6},{7,8}};
        System.out.println(minArrows.findMinArrowShots(input2) == 4);

        int[][] input3 = {{1,2},{2,3},{3,4},{4,5}};
        System.out.println(minArrows.findMinArrowShots(input3) == 2);

        int[][] input4 = {{10,16},{2,8},{3,5},{1,6},{7,12}};
        System.out.println(minArrows.findMinArrowShots(input4) == 2);

        int[][] input5 = {{10,16}};
        System.out.println(minArrows.findMinArrowShots(input5) == 1);

        int[][] input6 = {{10,16}, {12, 14}};
        System.out.println(minArrows.findMinArrowShots(input6) == 1);
    }
}
