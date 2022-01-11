package Educative.Patterns.TwoPointers;

import java.util.ArrayList;
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
    }

    public static boolean backspaceCompare(String s, String t) {

        List<Character> sList = new ArrayList<>();
        List<Character> tList = new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '#' ){
                if( sList.size() > 0)
                    sList.remove(sList.size() - 1);
            }
            else{
                sList.add(s.charAt(i));
            }
        }

        for(int i=0; i<t.length(); i++){
            if(t.charAt(i) == '#'){
                if(tList.size() > 0)
                    tList.remove(tList.size() - 1);
            }else{
                tList.add(t.charAt(i));
            }
        }

        return sList.equals(tList);

    }
}
