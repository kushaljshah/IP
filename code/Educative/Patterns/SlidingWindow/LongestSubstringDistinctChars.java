package Educative.Patterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 *
 * You can assume that K is less than or equal to the length of the given string.
 *
 * "aabbcc", k = 1
 * Max substring can be any one from {"aa" , "bb" , "cc"}.
 *
 * "aabbcc", k = 2
 * Max substring can be any one from {"aabb" , "bbcc"}.
 *
 * "aabbcc", k = 3
 * There are substrings with exactly 3 unique characters
 * {"aabbcc" , "abbcc" , "aabbc" , "abbc" }
 * Max is "aabbcc" with length 6.
 *
 * "aaabbb", k = 3
 * There are only two unique characters, thus show error message.
 *
 */

public class LongestSubstringDistinctChars {

    public static void main(String[] args) {
        uniqueChatSubs("xxyyzzabcxxxyyyzzz", 3);
    }

    private static void uniqueChatSubs(String str, int k){
        if(str == null || str.length() == 0 || k == 0)
            return;


        Map<Character, Integer> arrCount = new HashMap<>();
        int firstIndex = 0;

        int maxFirst = 0;
        int maxSize = 0;

        for(int i=0; i<str.length(); i++){
            arrCount.put(str.charAt(i), arrCount.getOrDefault(str.charAt(i), 0) + 1);
            while (arrCount.size() > k){
                arrCount.put(str.charAt(firstIndex), arrCount.getOrDefault(str.charAt(firstIndex), 0) - 1);
                if(arrCount.get(str.charAt(firstIndex)) <= 0)
                    arrCount.remove(str.charAt(firstIndex));

                firstIndex++;
            }

            if(i - firstIndex >= maxSize) {
                maxSize = (i - firstIndex) + 1;
                maxFirst = firstIndex;
            }

        }

        System.out.println(maxFirst);
        System.out.println(maxSize);




    }

}
