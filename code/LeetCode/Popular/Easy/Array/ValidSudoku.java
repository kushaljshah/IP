package LeetCode.Popular.Easy.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        HashMap[] rows = new HashMap[9];
        HashMap[] columns = new HashMap[9];
        HashMap[] boxes = new HashMap[9];


        for (int i=0; i<board.length - 1; i++){
            rows[i] = new HashMap<Character,Integer>();
            columns[i] = new HashMap<Character,Integer>();
            boxes[i] = new HashMap<Character,Integer>();
        }

        for (int i=0; i<board.length - 1; i++){
            for (int j=0; j<board[0].length - 1; j++){

                rows[i].put(board[i][j],1);
                columns[j].put(board[i][j],1);
                int boxId = (i/3) * 3 + j/3;
                boxes[boxId].put(boxId, 1);

                if(rows[i].containsKey(board[i][j]) || columns[j].containsKey(board[i][j]) || boxes[boxId].containsKey(board[i][j])){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char [] [] board = {
                {'1', '4', '7', '0', '0', '0', '0', '0', '3'},
                {'2', '5', '0', '0', '0', '1', '0', '0', '0'},
                {'3', '0', '9', '0', '0', '0', '0', '0', '0'},
                {'0', '8', '0', '0', '2', '0', '0', '0', '4'},
                {'0', '0', '0', '4', '1', '0', '0', '2', '0'},
                {'9', '0', '0', '0', '0', '0', '6', '0', '0'},
                {'0', '0', '3', '0', '0', '0', '0', '0', '9'},
                {'4', '0', '0', '0', '0', '2', '0', '0', '0'},
                {'0', '0', '1', '0', '0', '8', '0', '0', '7'},
        };

        System.out.println(isValidSudoku(board));
    }
}
