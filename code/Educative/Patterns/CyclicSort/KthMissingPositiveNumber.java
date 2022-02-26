package Educative.Patterns.CyclicSort;

import java.util.Arrays;

/**
 *
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 *
 * Find the kth positive integer that is missing from this array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 * Example 2:
 *
 * Input: arr = [1,2,3,4], k = 2
 * Output: 6
 * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 *
 *
 */


public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2,3,4,7,11}, 5));
        System.out.println(findKthPositive(new int[]{1,2,3,4}, 2));
        System.out.println(findKthPositive(new int[]{1,2,3,4}, 1));
        System.out.println(findKthPositive(new int[]{6,7,8,9}, 2));
        System.out.println(findKthPositive(new int[]{6,7,8,9}, 10));
    }

    public static int findKthPositive(int[] arr, int k) {
        int len = arr.length;
        int counter = 0;
        for(int i=1; i<arr[0]; i++){
             counter++;
             if(counter==k)
                 return i;
        }

        int m = arr[0];
        for(int j=0; j<len;){
            if(arr[j] == m){
                j++;
                m++;
            }else{
                counter++;
                if(counter == k)
                    return m;
                m++;
            }
        }

        return (k-counter) + arr[len-1];

    }


}
