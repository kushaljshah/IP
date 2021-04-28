package LeetCode.Popular.Easy.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Example 3:
 *
 * Input: digits = [0]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */

public class PlusOne {



    public static void main(String[] args) {
        int[] arr = new int[3];
        arr[0] = 9;
        arr[1] = 9;
        arr[2] = 9;


        System.out.println(Arrays.toString(plusOneV2(arr)));
    }

    public static int[] plusOneV2(int[] digits) {
        int[] ans;
        int len1 = digits.length - 1;
        int len2 = digits.length - 1;
        boolean newArrFlag = true;
        for(int i=0;i<digits.length;i++)
        {
            if(digits[i] != 9){
                newArrFlag = false;
                break;
            }
        }

        if(newArrFlag){
            len2 = len2 + 1;
            ans = new int[digits.length + 1];
        }else{
            ans = new int[digits.length];
        }

        getAns(digits, ans, len1, len2, false);

        return ans;
    }

    public static void getAns(int[] digits, int[] ans, int i, int j, boolean incFlag){
        int len = digits.length - 1;

        if(i < 0 && j == 0){
            ans[j] = 1;
            return;
        }

        if(i < 0 || j < 0)
            return;

        if(incFlag && digits[i] != 9){
            ans[j] = digits[i]+1;
            i--;
            j--;
            getAns(digits, ans, i, j, false);
        }else if(incFlag && digits[i] == 9){
            ans[j] = 0;
            i--;
            j--;
            getAns(digits, ans, i, j, true);
        }else if(i == len && digits[i] == 9){
            ans[j] = 0;
            i--;
            j--;
            getAns(digits, ans, i, j, true);
        }else if(i != len && digits[i] == 9){
            ans[j] = digits[i];
            i--;
            j--;
            getAns(digits, ans, i, j, false);
        }else if(i != len && digits[i] != 9){
            ans[j] = digits[i];
            i--;
            j--;
            getAns(digits, ans, i, j, false);

        }else if(i == len && digits[i] != 9){
            ans[j] = digits[i] + 1;
            i--;
            j--;
            getAns(digits, ans, i, j, false);
        }
    }

}
