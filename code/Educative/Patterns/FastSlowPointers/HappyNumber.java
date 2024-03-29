package Educative.Patterns.FastSlowPointers;

/**
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 *
 * Input: n = 2
 * Output: false
 */


public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
        System.out.println(isHappy(7));
    }

    public static boolean isHappy(int n) {
        if(n == 1)
            return true;

        int slow = n;
        int fast = getNextNumber(n);

        while (slow != 1 && fast != 1 && slow != fast) {
            slow = getNextNumber(slow);
            fast = getNextNumber(getNextNumber(fast));
        }

        if(slow == 1 || fast == 1)
            return true;

        return false;
    }

    public static int getNextNumber(int n){
        int totalSum = 0;
        while (n > 9){
            int mod = n % 10;
            totalSum = totalSum + (mod*mod);
            n = n / 10;
        }

        return totalSum + (n * n);
    }

}
