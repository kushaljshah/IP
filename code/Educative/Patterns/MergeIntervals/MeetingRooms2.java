package Educative.Patterns.MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 *
 * For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 */
public class MeetingRooms2 {

    public static int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int room = 0;
        for(int i = 0; i < intervals.length; i++){
            pq.offer(intervals[i][1]);
            if(intervals[i][0] < pq.peek()) {
                room++;
            }
            else{
                pq.poll();
            }
        }
        return room;
    }

    public static void main(String[] args) {
//        System.out.println(minMeetingRooms(new int[][]{{0,30}, {5,10}, {15,20}}));
        System.out.println(minMeetingRooms(new int[][]{{0,20}, {15,17}, {16,18}, {19, 35}}));

    }
}
