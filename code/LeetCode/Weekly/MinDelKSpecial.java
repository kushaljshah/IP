package LeetCode.Weekly;

import java.util.*;
import java.util.stream.Collectors;

public class MinDelKSpecial {

    public static int minimumDeletions(String word, int k) {
        int[] freq = new int[26];

        for(char ch : word.toCharArray()) {
            freq[ch-'a']++;
        }

        Arrays.sort(freq);

        int result = Integer.MAX_VALUE;
        int sumSoFar = 0;

        for(int i = 0; i < 26; i++) {
            int minFreq = freq[i];
            int temp = sumSoFar; //temp taken to find deletion for j = 25 to j > i
            if(freq[i] == 0)
                    continue;

            for(int j = 25; j > i; j--) {

                if(freq[j] - freq[i] <= k)
                    break;

                temp += freq[j] - minFreq - k;
            }

            result = Math.min(result, temp);
            sumSoFar += minFreq;
        }

        return result;
    }

    public static int minimumDeletions1(String word, int k) {
        int[] frequencies = new int[26];
        int counter = 0;

        for(int i =0; i<word.length(); i++){
            frequencies[word.charAt(i) - 'a']++;
        }

        System.out.println(Arrays.toString(frequencies));

        Arrays.sort(frequencies);
        System.out.println(Arrays.toString(frequencies));

        for(int j=25;j>=0;j--){
            for(int i=0; i<26;i++){
                if(frequencies[i] == 0)
                    continue;

                int diff = frequencies[j] - frequencies[i];
                if(diff > k){
                    int delta = (diff - k);
                    if(delta >= frequencies[i] && frequencies[i+1] > 1) {
                        counter = counter + frequencies[i];
                        frequencies[i] = 0;
                    }else {
                        counter = counter + delta;
                        frequencies[j] = frequencies[j] - delta;
                    }
                }else {
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(frequencies));

        return counter;

    }


    public static void main(String[] args) {
//        System.out.println(minimumDeletions("aabcaba", 0));
//        System.out.println(minimumDeletions("dabdcbdcdcd", 2));
//        System.out.println(minimumDeletions("aaabaaa", 2));
//        System.out.println(minimumDeletions("aabbcccdddddeeeeeee", 4));
//        System.out.println(minimumDeletions("itatwtiwwi", 1));
//        System.out.println(minimumDeletions("vvnowvov", 2));
        System.out.println(minimumDeletions("abc", 6));
    }


}
