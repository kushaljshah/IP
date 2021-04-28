package LeetCode.Popular.Easy.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kushal.shah
 */
public class FirstUniqueChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar(""));
        System.out.println(firstUniqChar("abc"));
        System.out.println(firstUniqChar("abca"));
        System.out.println(firstUniqChar("abcabc"));
    }

    public static int firstUniqChar(String s) {
        if(s.length() == 0)
            return -1;

        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for(int i=0; i<s.length(); i++){
            if (map.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return -1;

    }
}
