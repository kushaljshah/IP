package LeetCode.Daily.String;

/**
 * 79. Word Search
 * Medium
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 */

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    String substr = word.substring(1);
                    return existUtil(i+1, j, board, substr )|| existUtil(i, j+1, board, substr) ||
                            existUtil(i-1, j, board, substr) || existUtil(i, j-1, board, substr);
                }
            }
        }

        return false;
    }

    public static boolean existUtil(int i, int j, char[][] board, String word){
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0 || word.isEmpty()){
            return word.isEmpty();
        }

        if(board[i][j] == word.charAt(0)) {
            String substr = word.substring(1);
            return existUtil(i+1, j, board, substr )|| existUtil(i, j+1, board, substr) ||
                    existUtil(i-1, j, board, substr) || existUtil(i, j-1, board, substr);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][] {{'A','B','C','C'}, {'S','F','C','S'}, {'X','Y','Z','T'}}, "CCZY"));
        System.out.println(exist(new char[][] {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCCED"));
        System.out.println(exist(new char[][] {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCCEDAB"));
    }

}
