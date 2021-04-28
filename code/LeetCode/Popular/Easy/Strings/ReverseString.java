package LeetCode.Popular.Easy.Strings;

/**
 * Created by kushal.shah
 */
public class ReverseString {
    public static void reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
        while (i<j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        System.out.println(s);
        reverseString(s);
        System.out.println(s);
    }
}
