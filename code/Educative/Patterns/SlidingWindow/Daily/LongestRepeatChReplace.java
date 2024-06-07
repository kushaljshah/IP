package Educative.Patterns.SlidingWindow.Daily;

public class LongestRepeatChReplace {

    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int mostFreqLetter = 0;
        int left = 0;
        int max = 0;

        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;
            mostFreqLetter = Math.max(mostFreqLetter, freq[s.charAt(right) - 'A']);

            int lettersToChange = (right - left + 1) - mostFreqLetter;
            if(lettersToChange > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    // Partial solve
    /**
    public static int characterReplacement(String s, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        int start = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            freqMap.put(ch - 'A', freqMap.getOrDefault(ch - 'A', 0) + 1);
            while (!isValid(freqMap, ch, k)){
                int startCh = s.charAt(start);
                freqMap.put(startCh - 'A', freqMap.getOrDefault(startCh - 'A', 0) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, (i-start) + 1);

        }

        return maxLength;

    }

    public static boolean isValid(Map<Integer, Integer> freqMap, char ch, int k){
        if(ch != startCh){
            int violationsCount = 0;
            for (int i=0; i<26; i++){
                if(i != startCh - 'A' ) {
                    violationsCount += freqMap.getOrDefault(i, 0);
                }
            }
            return violationsCount <= k;
        }

        return true;
    }
     **/

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
    }


}
