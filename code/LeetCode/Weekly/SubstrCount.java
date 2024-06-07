package LeetCode.Weekly;


/**
 * You are given a string s and a character c. Return the total number of substrings of s that start and end with c.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abada", c = "a"
 *
 * Output: 6
 *
 * Explanation: Substrings starting and ending with "a" are: "abada", "abada", "abada", "abada", "abada", "abada".
 *
 * Example 2:
 *
 * Input: s = "zzz", c = "z"
 *
 * Output: 6
 *
 * Explanation: There are a total of 6 substrings in s and all start and end with "z".
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s and c consist only of lowercase English letters.
 */
public class SubstrCount {

    public static long countSubstrings(String s, char c) {
        long individualCounter = 0;
        long combinationCounter = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == c) {
                combinationCounter = combinationCounter + individualCounter;
                individualCounter++;
            }
        }

        return combinationCounter+ individualCounter;
    }
    public static void main(String[] args) {
        System.out.println(countSubstrings("ababa", 'a'));
        System.out.println(countSubstrings("abcba", 'a'));
        System.out.println(countSubstrings("zzz", 'z'));
        System.out.println(countSubstrings("aaaaa", 'a'));
    }

}
