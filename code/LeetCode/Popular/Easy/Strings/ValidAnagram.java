package LeetCode.Popular.Easy.Strings;

/**
 * Created by kushal.shah
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        int[] counter = new int[26];
        if(s.length() != t.length()){
            return false;
        }

        for(int i=0; i<s.length(); i++){
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for(int count: counter){
            if(count > 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("stu", "tus"));
        System.out.println(isAnagram("stu", "tuss"));
        System.out.println(isAnagram("stu", "tux"));
    }
}
