package LeetCode.Daily.String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 205. Isomorphic Strings
 * Easy
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {

        // Create arrays to store the frequency of characters in both strings
        int[] freqS = new int[128]; // Stores frequency of characters in string s
        int[] freqT = new int[128]; // Stores frequency of characters in string t

        // Get the length of both strings
        int len = s.length();

        // If the lengths of the two strings are different, they can't be isomorphic
        if(len != t.length()) {
            return false;
        }

        // Iterate through each character of the strings
        for(int i = 0; i < len; i++) {
            // Check if the frequency of the current character in string s
            // is different from the frequency of the corresponding character in string t
            if(freqS[s.charAt(i)] != freqT[t.charAt(i)]) {
                return false; // If different, strings are not isomorphic
            }

            // Update the frequencies of characters in both strings
            freqS[s.charAt(i)] = i + 1; // Incrementing frequency of character in string s
            freqT[t.charAt(i)] = i + 1; // Incrementing frequency of character in string t
        }

        // If the loop completes without returning false, strings are isomorphic
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isIsomorphic("s", "t"));
        System.out.println(isIsomorphic("sssa", "tttb"));
        System.out.println(isIsomorphic("aaaa", "taaa"));
        System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphic("badc", "baba"));
    }


}
