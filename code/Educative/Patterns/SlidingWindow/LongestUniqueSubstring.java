package Educative.Patterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LongestUniqueSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwpkew"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;

        int firstIndex = 0;
        int maxLength = 0;
        int curLength = 0;
        Map<Character, Integer> charFrequency = new HashMap<>();
        for(int i =0; i< s.length(); i++){
            charFrequency.put(s.charAt(i), charFrequency.getOrDefault(s.charAt(i), 0) + 1);
            while (charFrequency.get(s.charAt(i)) > 1){
                charFrequency.put(s.charAt(firstIndex), charFrequency.get(s.charAt(firstIndex)) - 1);
                if(charFrequency.get(s.charAt(firstIndex)) == 0)
                    charFrequency.remove(s.charAt(firstIndex));

                firstIndex++;
                curLength--;

            }

            curLength++;

            if(curLength > maxLength)
                maxLength = curLength;

        }

        return maxLength;
    }
}
