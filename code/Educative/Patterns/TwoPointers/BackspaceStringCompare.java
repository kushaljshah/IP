package Educative.Patterns.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 *
 * Input: s = "a##c", t = "#a#c"
 * Output: true
 * Explanation: Both s and t become "c".
 * Example 4:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 */


public class BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare("a#c", "b"));
        System.out.println(backspaceCompare("y#fo##f","y#f#o##f"));
        System.out.println(backspaceCompare("bxj##tw","bxo#j##tw"));
    }

    public static boolean backspaceCompare(String s, String t) {

        int start1 = 0;
        char[] nums1 = new char[s.length()];
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != '#'){
                nums1[start1] = s.charAt(i);
                s = s.substring(0, start1) + s.charAt(i) + s.substring(start1+1);
                start1++;
            }else {
                if(start1 > 0)
                    start1--;
            }
        }

        int start2 = 0;
        char[] nums2 = new char[s.length()];
        for(int i=0; i<t.length(); i++){
            if(t.charAt(i) != '#'){
                nums2[start2] = t.charAt(i);
                t = t.substring(0, start2) + t.charAt(i) + t.substring(start2+1);
                start2++;
            }else {
                if(start2 > 0)
                    start2--;
            }
        }

        return ((String) String.valueOf(s.substring(0, start1))).equals(((String) String.valueOf(t.substring(0, start2))));
    }

    public static boolean mine_backspaceCompare(String s, String t) {

        List<Character> sList = new ArrayList<>();
        List<Character> tList = new ArrayList<>();

        for(int start=0; start<s.length(); start++){
            if(s.charAt(start) == '#' ){
                if( sList.size() > 0)
                    sList.remove(sList.size() - 1);
            }
            else{
                sList.add(s.charAt(start));
            }
        }

        for(int start=0; start<t.length(); start++){
            if(t.charAt(start) == '#'){
                if(tList.size() > 0)
                    tList.remove(tList.size() - 1);
            }else{
                tList.add(t.charAt(start));
            }
        }

        return sList.equals(tList);

    }
}
