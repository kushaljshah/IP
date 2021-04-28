package LeetCode.Popular.Easy.Array;

import java.util.Arrays;

/**
 * Created by kushal.shah
 */
public class RotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        int loop = 0;
        int loop1 = n-1;
        for(int i=0; i<=n/2;i++){
            int[] tmp = new int[4];
            for(int j=loop; j<=loop1; j++){

                int row = i;
                int column = j;

                for(int k=0; k<4;k++){
                    tmp[k] = matrix[row][column];
                    if(k>0){
                        matrix[row][column] = tmp[k-1];
                    }
                    int tmp1 = row;
                    row = column;
                    column = n - tmp1;
                }
                matrix[row][column] = tmp[3];
            }

            loop++;
            loop1--;
        }

    }



    public static void main(String[] args) {
        int [] [] board = {
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16},
        };

//        int [] [] board = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9},
//        };

        System.out.println(Arrays.deepToString(board));
        rotate(board);
        System.out.println(Arrays.deepToString(board));
    }

}
