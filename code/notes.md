1. Check the bounds of array
2. Check the size of internal DS required ex: float, integer
3. Check if +ve, -ve, 0 numbers accepted
4. Handle all corner cases: empty, null, duplicate cases
5. Never copy lines. Always write. Ex: copy loop of i in j
6. Make sure all test cases are covered for a question. Infact before starting the solution try to cover all test cases 
   before hand. Ex: for sliding window questions, the patterns should be alternate, match in star and nothing towards 
   end, vice versa, match in the middle only.
7. For any question, write down the solution with a few examples and write the code viewing it step by step
   ex: Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
   Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
   Explanation:
   Window position                Median
   ---------------                -----
   [1  3  -1] -3  5  3  6  7        1
   1 [3  -1  -3] 5  3  6  7       -1
   1  3 [-1  -3  5] 3  6  7       -1
   1  3  -1 [-3  5  3] 6  7        3
   1  3  -1  -3 [5  3  6] 7        5
   1  3  -1  -3  5 [3  6  7]       6
8. Ask questions on the constraionts of problem. Ex: COnstraints of k here
   https://leetcode.com/problems/sliding-window-median/
9. When in your code you are working with integers but returning a higher value range like double, there can be overflow due to some arithmetic operations. This needs to be taken car eof.
   ex: https://leetcode.com/submissions/detail/649104827/
10. Whenver there is an unknown problem, try to code to interfaces. Write down methods which will do certain functionalities. This will also be helpful later when complexity analysis is done. 
