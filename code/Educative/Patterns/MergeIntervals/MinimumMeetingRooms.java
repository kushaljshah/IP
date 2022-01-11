package Educative.Patterns.MergeIntervals;

/**
 *
 * Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.
 *
 * Example :
 * Meetings: [[4,5], [2,3], [2,4], [3,5]]
 * Output: 2
 * Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].
 *
 */

public class MinimumMeetingRooms {

    /**
     *
     * Here is what our strategy will look like:
     *
     * We will sort the meetings based on start time.
     * We will schedule the first meeting (let’s call it m1) in one room (let’s call it r1).
     * If the next meeting m2 is not overlapping with m1, we can safely schedule it in the same room r1.
     * If the next meeting m3 is overlapping with m2 we can’t use r1, so we will schedule it in another room (let’s call it r2).
     * Now if the next meeting m4 is overlapping with m3, we need to see if the room r1 has become free. For this, we need to keep track of the end time of the meeting happening in it. If the end time of m2 is before the start time of m4, we can use that room r1, otherwise, we need to schedule m4 in another room r3.
     *
     */

}
