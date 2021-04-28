package LeetCode.Popular.Easy.Strings;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kushal.shah
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        if (n <= 0)
            return null;

        String result = "1";
        int i = 1;

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }

        return result;
    }

//    public static String countAndSay(int n) {
//
//        LinkedList<Integer> prevSeq = new LinkedList<Integer>();
//        prevSeq.add(1);
//        // Using -1 as the delimiter
//        prevSeq.add(-1);
//
//        List<Integer> finalSeq = nextSequence(n, prevSeq);
//        StringBuffer seqStr = new StringBuffer();
//        for (Integer digit : finalSeq) {
//            seqStr.append(String.valueOf(digit));
//        }
//        return seqStr.toString();
//    }
//
//    protected static LinkedList<Integer> nextSequence(int n, LinkedList<Integer> prevSeq) {
//        if (n <= 1) {
//            // remove the delimiter before return
//            prevSeq.pollLast();
//            return prevSeq;
//        }
//
//        LinkedList<Integer> nextSeq = new LinkedList<Integer>();
//        Integer prevDigit = null;
//        Integer digitCnt = 0;
//        for (Integer digit : prevSeq) {
//            if (prevDigit == null) {
//                prevDigit = digit;
//                digitCnt += 1;
//            } else if (digit == prevDigit) {
//                // in the middle of the sub-sequence
//                digitCnt += 1;
//            } else {
//                // end of a sub-sequence
//                nextSeq.add(digitCnt);
//                nextSeq.add(prevDigit);
//                // reset for the next sub-sequence
//                prevDigit = digit;
//                digitCnt = 1;
//            }
//        }
//
//        // add the delimiter for the next recursion
//        nextSeq.add(-1);
//        return nextSequence(n - 1, nextSeq);
//    }

   // -------------------------------

//    public static String countAndSay(int n) {
//        if(n == 1)
//            return "1";
//
//        String sayResult = "1";
//        for(int i=2; i<=n; i++){
//            sayResult = say(Double.parseDouble(sayResult));
//        }
//
//        return sayResult;
//
//    }
//
//    public static String say(double n) {
//        StringBuilder result = new StringBuilder();
//        int element = 0;
//        int nextElement = 0;
//        int count = 0;
//
//        while (n > 0){
//            element = (int) (n % 10);
//            n = Math.floor(n /10);
//            nextElement = (int) (n % 10);
//
//            if(element ==  nextElement){
//                count++;
//            }else{
//
//                result.insert(0,element);
//                result.insert(0,count+1);
//                count = 0;
//            }
//
//        }
//
//        return result.toString();
//
//    }

    // -------------------------------

    public static void main(String[] args) {
//        System.out.println(countAndSay(4));
        System.out.println(countAndSay(4));
    }
}
