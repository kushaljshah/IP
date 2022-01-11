package Educative.Patterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 *  (Solution: https://medium.com/consol/longest-substring-with-the-same-letters-after-replacement-sliding-window-a00760a36e85)
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 */

/**
 * IMP
 */
public class LongestSubStrReplacement {

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABAABBBBBBB", 1)); //8
        System.out.println(characterReplacement("ABAB", 1)); //3
        System.out.println(characterReplacement("ABAB", 2)); //4
        System.out.println(characterReplacement("ABBBBBADBB", 1)); //6
        System.out.println(characterReplacement("ABABB", 1)); //4
        System.out.println(characterReplacement("ABABB", 2)); //5
        System.out.println(characterReplacement("ABBBBB", 1)); //6
        System.out.println(characterReplacement("AABAB", 1)); //4
        System.out.println(characterReplacement("ABABBBBB", 1)); //7
        System.out.println(characterReplacement("ABAB", 2)); // 4
        System.out.println(characterReplacement("ABABBA", 1)); //4
        System.out.println(characterReplacement("AABABBA", 1)); //4
    }

    // Doesn't work for backward replacements
    public static int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0)
            return 0;

        int firstIndex = 0;
        int maxLength = 0;
        int currLength = 0;
        int maxRepeat = 0;
        Map<Character, Integer> charFrequency = new HashMap<>();
        for(int endIndex=0; endIndex<s.length(); endIndex++){
            charFrequency.put(s.charAt(endIndex), charFrequency.getOrDefault(s.charAt(endIndex), 0) + 1);
            maxRepeat = Math.max(maxRepeat, charFrequency.get(s.charAt(endIndex))); // This is the key statement
            currLength = (endIndex - firstIndex) + 1;
            while (currLength - maxRepeat > k) {
                charFrequency.put(s.charAt(firstIndex), charFrequency.get(s.charAt(firstIndex)) - 1);
                firstIndex++;
                currLength--;
            }

            if(currLength > maxLength)
                maxLength = currLength;
        }

        return maxLength;
    }
}
