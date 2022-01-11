package Educative.Patterns.SlidingWindow;

import java.util.*;

/**
 * Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
 *
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * Example 2:
 *
 * Input: words = ["cat","dog","catdog"]
 * Output: ["catdog"]
 */

public class ConcentratedWords {

    public static void main(String[] args) {
        System.out.println(findAllConcatenatedWordsInADict(new String[]{"cat","cats","dog", "catsdogcats", ""}));
        System.out.println(findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
        System.out.println(findAllConcatenatedWordsInADict(new String[]{"cat","dog","catdog"}));
    }

    public static class TrieNode{

        HashMap<Character,TrieNode> children;
        Character value;
        boolean isLeaf;

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public Character getValue() {
            return value;
        }

        public boolean isLeaf() {
            return isLeaf;
        }

        public TrieNode(Character ch){
            this.children = new HashMap<>();
            this.value = ch;
            this.isLeaf = false;
        }

        public void addChildren(TrieNode node){
            this.children.put(node.value, node);
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    ", value=" + value +
                    ", isLeaf=" + isLeaf +
                    '}';
        }
    }

    public static void insert(TrieNode root, String word){
        if(word == null || word.length() == 0)
            return;

        TrieNode trieNode = root;

        for(int i=0; i<word.length(); i++){
            Character ch = word.charAt(i);
            TrieNode node;
            if(trieNode.children.containsKey(ch)) {
                node = trieNode.children.get(ch);
            }else{
                node = new TrieNode(word.charAt(i));
                trieNode.addChildren(node);
            }

            trieNode = node;

        }

        trieNode.isLeaf = true;
    }

    public static boolean search(TrieNode root, String word){
        if(word.equals(""))
            return true;

        TrieNode curr = root;
        for(int i=0; i<word.length(); i++){
            if(curr.getChildren().containsKey(word.charAt(i))) {
                if(curr.getChildren().get(word.charAt(i)).isLeaf && (search(root, word.substring(i+1)))){
                    return true;
                }
                curr = curr.getChildren().get(word.charAt(i));
            }else {
                return false;
            }
        }

        return false;
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        ArrayList<String> result = new ArrayList<>();

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

//        System.out.println(Arrays.toString(words));

        TrieNode root = new TrieNode(null);
        for(String word: words){
            if(word != null && !word.equals("")) {
                if (search(root, word)) {
                    result.add(word);
                } else {
                    insert(root, word);
                }
            }
        }

//        printTrieNode(root);

//        System.out.println(result);
        return result;
    }




    public static void printTrieNode(TrieNode root){
        System.out.println(root);
        for (Map.Entry<Character, TrieNode> entry: root.getChildren().entrySet()){
            printTrieNode(entry.getValue());
        }
        System.out.println("-----------------------");
    }

    public static List<String> DP_Solution_findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        for (int i = 0; i < words.length; i++) {
            if (DP_Solution_canForm(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }

        return result;
    }

    private static boolean DP_Solution_canForm(String word, Set<String> dict) {
        if (dict.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (dict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }

}
