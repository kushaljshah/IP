package LeetCode.L75.Medium;

import java.util.Stack;

/** 151.
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Optimal solution
 * https://leetcode.com/problems/reverse-words-in-a-string/solutions/4884894/best-explanation-with-photos-without-extra-space-beats-100-in-time-95-in-space/?envType=study-plan-v2&envId=leetcode-75
 * https://www.youtube.com/watch?v=RgYLxtlkKo8
 */
public class ReverseWords {

    public static String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder word = new StringBuilder();
        int len = s.length();
        for (int i=0; i<len; i++){
            if(s.charAt(i)!=' '){
                word.append(s.charAt(i));
            }else {
                if(!word.isEmpty()) {
                    stack.add(word.toString());
                    word.delete(0, word.length());
                }
            }
        }

        if(!word.isEmpty()) {
            stack.add(word.toString());
            word.delete(0, word.length());
        }

        System.out.println(stack);
        s = "";
        while (!stack.isEmpty()){
            s = s + stack.pop();
            if(!stack.isEmpty())
                s = s + ' ';
        }
        return s;

    }

    public static void main(String[] args) {
        System.out.println(reverseWords("              abc    d e          "));
    }
}
