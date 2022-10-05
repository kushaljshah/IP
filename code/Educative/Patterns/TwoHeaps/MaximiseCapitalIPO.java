package Educative.Patterns.TwoHeaps;

import java.util.PriorityQueue;

/**
 *
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
 *
 * You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
 *
 * Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
 *
 * Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.
 *
 * The answer is guaranteed to fit in a 32-bit signed integer.
 *
 *
 *
 * Example 1:
 *
 * Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
 * Output: 4
 * Explanation: Since your initial capital is 0, you can only start the project indexed 0.
 * After finishing it you will obtain profit 1 and your capital becomes 1.
 * With capital 1, you can either start the project indexed 1 or the project indexed 2.
 * Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
 * Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
 * Example 2:
 *
 * Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
 * Output: 6
 *
 */

public class MaximiseCapitalIPO {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        // to speed up: if all projects are available
        boolean speedUp = true;
        for (int c: Capital) if (W < c) speedUp = false;
        if (speedUp) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int p: Profits) {
                heap.add(p);
                if (heap.size() > k) heap.poll();
            }
            for (int h: heap) W += h;
            return W;
        }

        int idx;
        int n = Profits.length;
        for(int i = 0; i < Math.min(k, n); ++i) {
            idx = -1;
            // if there are available projects,
            // pick the most profitable one
            for(int j = 0; j < n; ++j) {
                if (W >= Capital[j]) {
                    if (idx == -1 ) idx = j;
                    else if (Profits[idx] < Profits[j]) idx = j;
                }
            }
            // not enough capital to start any project
            if(idx == -1) break;

            // add the profit from chosen project
            // and remove the project from further consideration
            W += Profits[idx];
            Capital[idx] = Integer.MAX_VALUE;
        }
        return  W;
    }
}
