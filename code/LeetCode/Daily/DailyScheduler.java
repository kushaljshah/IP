package LeetCode.Daily;

import java.util.*;

/**
 * You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.
 *
 * ​Return the minimum number of intervals required to complete all tasks.
 *
 *
 *
 * Example 1:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 *
 * Output: 8
 *
 * Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 * After completing task A, you must wait two cycles before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th cycle, you can do A again as 2 intervals have passed.
 *
 * Example 2:
 *
 * Input: tasks = ["A","C","A","B","D","B"], n = 1
 *
 * Output: 6
 *
 * Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
 *
 * With a cooling interval of 1, you can repeat a task after just one other task.
 *
 * Example 3:
 *
 * Input: tasks = ["A","A","A", "B","B","B"], n = 3
 *
 * Output: 10
 *
 * Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.
 *
 * There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.
 *
 *
 *
 * Constraints:
 *
 * 1 <= tasks.length <= 104
 * tasks[i] is an uppercase English letter.
 * 0 <= n <= 100
 */
public class DailyScheduler {

    public static int leastInterval(char[] tasks, int n) {
//        System.out.println(tasks);
        if(n == 0)
            return tasks.length;

        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for(int i=0; i<tasks.length; i++){
            charFrequencyMap.put(tasks[i], charFrequencyMap.getOrDefault(tasks[i], 0) + 1);
        }

//        System.out.println(charFrequencyMap);
        PriorityQueue<Integer> pq = new PriorityQueue<>(charFrequencyMap.size(), Collections.reverseOrder());
        pq.addAll(charFrequencyMap.values());
//        System.out.println(pq);
        int counter = 0;
        while (!pq.isEmpty()){
            List<Integer> pqRemovals = new ArrayList<>();
            for (int i=0; i<n+1; i++){
                if (!pq.isEmpty()) {
                    int element = pq.remove();
                    if(element - 1 > 0)
                        pqRemovals.add(element - 1);
                    counter++;
                }else{
                    if (!pqRemovals.isEmpty())
                        counter++;
                }
            }

            pq.addAll(pqRemovals);

        }


        return counter;
    }

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(leastInterval(new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 1));
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3));
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 1));
        System.out.println(leastInterval(new char[]{'A'}, 1));
        System.out.println(leastInterval(new char[]{'A'}, 10));
    }

}
