package LeetCode.Daily.Binary;

import java.util.*;

/**
 *

 https://www.youtube.com/watch?v=gUNHcfIZvIk
 We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).

 Let's define a and b as follows:

 a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 Note that ^ denotes the bitwise-xor operation.

 Return the number of triplets (i, j and k) Where a == b.



 Example 1:

 Input: arr = [2,3,1,6,7]
 Output: 4
 Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
 Example 2:

 Input: arr = [1,1,1,1,1]
 Output: 10


 Constraints:

 1 <= arr.length <= 300
 1 <= arr[i] <= 108
 */
public class TripletsFromXor {

    /**
    O(n2)
    public static int countTriplets(int[] arr) {
        int result = 0;
        if(arr.length <= 1)
            return result;

        for(int i=0; i<arr.length; i++){
            int xor = arr[i];
            for(int j = i+1; j< arr.length; j++){
                xor = xor ^ arr[j];
                if(xor == 0){
                    result = result + (j - i);
                    System.out.println(i + " - " + j);
                }
            }
        }

        return result;
    }

     **/

//    public static int countTriplets(int[] arr) {
//        Map<Integer, List<Integer>> prefixMap = new HashMap<>();
//        int xor = 0;
//        for(int i=1; i<arr.length;i++){
//
//        }
//
//    }

//    public static void main(String[] args) {
////        System.out.println(countTriplets(new int[]{2,3,1,6,7}));
//        System.out.println(countTriplets(new int[]{1,1,1,1,1}));
//    }

}
