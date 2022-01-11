package Educative.Patterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 */

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("A", "A"));
        System.out.println(minWindow("AB", "B"));
        System.out.println(minWindow("acbbaca","aba"));
    }

    public static String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length())
            return "";

        Map<Character, Integer> string1Map = new HashMap<>();
        Map<Character, Integer> string2Map = new HashMap<>();

        for(int i = 0; i< t.length(); i++){
            string2Map.put(t.charAt(i), string2Map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int firstIndex = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int currentWindowSize = 0;
        String result = "";

        for(int endIndex = 0; endIndex< s.length(); endIndex++){
            if(string2Map.containsKey(s.charAt(endIndex))){
                string1Map.put(s.charAt(endIndex), string1Map.getOrDefault(s.charAt(endIndex), 0) + 1);
//                if(string1Map.getOrDefault(s.charAt(endIndex), 0) > string2Map.getOrDefault(s.charAt(endIndex), 0)){
//                    if(string1Map.containsKey(s.charAt(firstIndex))) {
//                        string1Map.put(s.charAt(firstIndex), string1Map.get(s.charAt(firstIndex)) - 1);
//                        if (string1Map.get(s.charAt(firstIndex)) == 0)
//                            string1Map.remove(s.charAt(firstIndex));
//                    }
//
//                    firstIndex++;
//                }
            }

//            while (string1Map.equals(string2Map)){
            while (match(string2Map, string1Map)){
                currentWindowSize = (endIndex - firstIndex) + 1;
                if(currentWindowSize < minWindowSize){
                    minWindowSize = currentWindowSize;
                    result = s.substring(firstIndex, endIndex + 1);
                }

                if(string1Map.containsKey(s.charAt(firstIndex))) {
                    string1Map.put(s.charAt(firstIndex), string1Map.get(s.charAt(firstIndex)) - 1);
                    if (string1Map.get(s.charAt(firstIndex)) == 0)
                        string1Map.remove(s.charAt(firstIndex));
                }
                firstIndex++;

                while (firstIndex < s.length() && !string2Map.containsKey(s.charAt(firstIndex))){
                    if(string1Map.containsKey(s.charAt(firstIndex))) {
                        string1Map.put(s.charAt(firstIndex), string1Map.get(s.charAt(firstIndex)) - 1);
                        if (string1Map.get(s.charAt(firstIndex)) == 0)
                            string1Map.remove(s.charAt(firstIndex));
                    }

                    firstIndex++;
                }

//                if(string1Map.equals(string2Map)) {
//                    currentWindowSize = (endIndex - firstIndex) + 1;
//                    if (currentWindowSize < minWindowSize) {
//                        minWindowSize = currentWindowSize;
//                        result = s.substring(firstIndex, endIndex + 1);
//                    }
//                }

            }

//            if(string1Map.isEmpty())
//                firstIndex++;

        }

        return result;
    }

    private static boolean match(Map<Character, Integer> s1Map, Map<Character, Integer> s2Map){
        for(Map.Entry<Character, Integer> entry: s1Map.entrySet()){
            if(s2Map.getOrDefault(entry.getKey(), 0) < entry.getValue())
                return false;
        }

        return true;
    }

}
