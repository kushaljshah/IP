package LeetCode.Popular.Easy.Strings;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
                else {
                    System.out.println("in");
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strArr = {"apple", "ape", "april"};
        System.out.println(longestCommonPrefix(strArr));
    }
}

