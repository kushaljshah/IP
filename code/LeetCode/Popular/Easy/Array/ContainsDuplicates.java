package LeetCode.Popular.Easy.Array;

/**
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 */

import java.util.*;

public class ContainsDuplicates {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> counerMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            Integer count = counerMap.get(nums[i]);
            if(count == null)
                counerMap.put(nums[i], 1);
            else{
                return true;
            }
        }

        return false;
    }

    /**
     * Solution 1:
     *
     * Approach:The elements in the array is from 0 to n-1 and all of them are positive. So to find out the duplicate elements, a HashMap is required, but the question is to solve the problem in constant space. There is a catch, the array is of length n and the elements are from 0 to n-1 (n elements). The array can be used as a HashMap.
     * Algorithm:
     * Traverse the array from start to end.
     * For every element,take its absolute value and if the abs(array[i])‘th element is positive, the element has not encountered before, else if negative the element has been encountered before print the absolute value of the current element.
     */

    public boolean containsDuplicate2(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[Math.abs(nums[i])] > 0){
                nums[Math.abs(nums[i])] = -1 * nums[Math.abs(nums[i])];
            }else{
                return true;
            }
        }

        return false;
    }

    /**
     * Approach: The basic idea is to use a HashMap to solve the problem. But there is a catch, the numbers in the array are from 0 to n-1,
     * and the input array has length n. So, the input array can be used as a HashMap. While Traversing the array, if an element ‘a’ is encountered
     * then increase the value of a%n‘th element by n. The frequency can be retrieved by dividing the a % n’th element by n.
     *
     * Algorithm:
     * Traverse the given array from start to end.
     * For every element in the array increment the arr[i]%n‘th element by n.
     * Now traverse the array again and print all those indexes i for which arr[i]/n is greater than 1. Which guarantees that the number n has been added to that index
     * This approach works because all elements are in the range from 0 to n-1 and arr[i] would be greater than n only if a value “i” has appeared more than once.
     */

    public static void main(String args[]) {
        int numRay[] = {0, 4, 3, 2, 7, 8, 2, 3, 1};

        for (int i = 0; i < numRay.length; i++) {
            numRay[numRay[i] %  numRay.length] = numRay[numRay[i] %  numRay.length] + numRay.length;
        }
        System.out.println("The repeating elements are : ");
        for (int i = 0; i < numRay.length; i++) {
            if (numRay[i] >= numRay.length*2) {
                System.out.println(i + " ");
            }
        }
    }

}
