package Educative.Patterns.CyclicSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
 *
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [1,1,2]
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: []
 *
 */


public class AllDuplicateNumbers {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(findDuplicate(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(findDuplicate(new int[]{1,1,2}));
        System.out.println(findDuplicate(new int[]{1}));
    }

    public static List<Integer> findDuplicate(int[] nums) {
        Set<Integer> result = new HashSet<>();

        int i = 0;
        while (i < nums.length){
            int j = nums[i] - 1;
            if(nums[j] != nums[i]){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }else{
                if(i == j)
                    i++;
                else {
                    result.add(nums[i]);
                    i++;
                }

            }
        }

        return new ArrayList<>(result);

    }

}
