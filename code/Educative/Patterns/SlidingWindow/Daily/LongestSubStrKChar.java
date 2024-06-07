package Educative.Patterns.SlidingWindow.Daily;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrKChar {

    public int longestSubstringWithKDistinctChars(String s, int k) {
        int start = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        for(int i =0; i<s.length();i++){
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
            while (freqMap.size() > k){
                char startChar = s.charAt(start);
                freqMap.put(s.charAt(i), freqMap.getOrDefault(startChar, 0) - 1);
                if(freqMap.get(startChar) == 0)
                    freqMap.remove(startChar);
                start++;
            }
            maxLength = Math.max(maxLength, ((i - start) + 1));
        }

        return (maxLength == Integer.MIN_VALUE) ? 0 : maxLength;
    }


}
