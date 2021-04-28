package LeetCode.Popular.Easy.Strings;

/**
 * Created by kushal.shah
 */
public class StrStr {

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("", "bba"));
        System.out.println(strStr("bba", ""));
        System.out.println(strStr("", ""));
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("mississippi", "issip"));
        System.out.println(strStr("maxipmaxir", "maxir"));
        System.out.println(strStr("mississippi", "sippia"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length())
            return -1;

        if (needle.length() == 0)
            return 0;

        if (haystack.length() == 0)
            return -1;

        if(haystack.length() == needle.length())
            return haystack.equals(needle) ? 0 : -1;

        int index = -1;
        int i=0;
        int j=0;
        for (; i < haystack.length()-needle.length(); ) {
            for (; j < needle.length(); ) {
                if (i == haystack.length() || j == needle.length())
                    break;
                if (haystack.charAt(i) == needle.charAt(j)) {
                    if (index == -1)
                        index = i;

                    i++;
                    j++;

                    if (j == needle.length())
                        return index;
                } else if (j > 0) {
                    j = 0;
                    i = index + 1;
                    index = -1;
                } else {
                    i++;
                }
            }
        }

        if(j == needle.length() + 1)
            return index;
        else
            return -1;
    }
}



//    public static int strStr(String haystack, String needle) {
//
//        if(needle.length() > haystack.length())
//            return -1;
//
//        if(needle.length() == 0)
//            return 0;
//
//        if(haystack.length() == 0)
//            return -1;
//
//        int i = 0;
//        int j = 0;
//        int index = -1;
//        while (j != haystack.length()){
//            if(haystack.charAt(j) == needle.charAt(i)){
//                if(index == -1)
//                    index = j;
//
//                i++;
//                j++;
//
//                if(i == needle.length())
//                    break;
//
//
//
//
//            }else if(i > 0){
//                i = 0;
//                int tmp = j;
//                while (haystack.charAt(j) != needle.charAt(i)){
//                    j--;
//                }
//
//                if(j == index){
//                    j = tmp;
//                    j++;
//                    index = -1;
//                }else {
//                    index = j;
//                }
//
//            }
//            else {
//                j++;
//            }
//        }
//
//
//        if(i == needle.length())
//            return index;
//        else
//            return -1;
//    }
