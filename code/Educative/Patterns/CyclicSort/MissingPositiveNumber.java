package Educative.Patterns.CyclicSort;

import java.util.Arrays;

/**
 *
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 *
 */


public class MissingPositiveNumber {

    public static void main(String[] args) {
        System.out.println(firstMissingPositiveNew(new int[]{1,2,0}));
        System.out.println("");
        System.out.println(firstMissingPositiveNew(new int[]{3,4,-1,1}));
        System.out.println("");
        System.out.println(firstMissingPositiveNew(new int[]{7,8,9,11,12}));
        System.out.println("");
        System.out.println(firstMissingPositiveNew(new int[]{1,2,3}));
        System.out.println("");
        System.out.println(firstMissingPositiveNew(new int[]{0,2,3}));
        System.out.println("");
        System.out.println(firstMissingPositiveNew(new int[]{-1,1,2}));
        System.out.println("");
        System.out.println(firstMissingPositiveNew(new int[]{-10,-11,2,3}));
        System.out.println("");
        System.out.println(firstMissingPositiveNew(new int[]{-10,-11,1,2}));
        System.out.println("");
        System.out.println(firstMissingPositiveNew(new int[]{-10,-11,2,4}));
        System.out.println("");
        System.out.println(firstMissingPositiveNew(new int[]{-10,-11,-12,2,4}));
        System.out.println("");
        System.out.println(firstMissingPositiveNew(new int[]{1,1}));
        System.out.println("");
    }

    public static int firstMissingPositiveNew(int[] nums) {
        System.out.println(Arrays.toString(nums));
        for(int i=0 ; i<nums.length;){
//            if(nums[i] > 0 && nums[i] <= nums.length && i != nums[i] - 1){
            int correctIdx = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctIdx]) {
                swap(nums, i, nums[i] - 1);
            }else{
                i++;
            }
        }

        System.out.println(Arrays.toString(nums));

        for(int i=0; i<nums.length; i++){
            if(i != nums[i] -1)
                return i+1;
        }


        return nums.length + 1;

    }

    static void swap(int[] nums, int index1, int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }


    public static int firstMissingPositiveOld(int[] nums) {
        int min = getMinPositiveNumber(nums);

        int i = 0;
        int positiveNum = 1;
        while (i < nums.length - 1){
            int numi = nums[i] - min;
            int j = nums[numi];
            int numj = j - min;
            if(nums[numj] != nums[i]){
                int tmp = nums[i];
                nums[i] = nums[numj];
                nums[numj] = tmp;
            }else{
                if(nums[i] > 0){
                    if(nums[i] == positiveNum){
                        i++;
                        positiveNum++;
                    }else{
                        return positiveNum;
                    }
                }else{
                    i++;
                }
            }
        }

        return positiveNum;

    }

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int min = getMinPositiveNumber(nums);
        int i = 0;
        for(int k=0; k<len; k++){
            if(nums[k] >= 0)
                nums[k] = nums[k] - min;
        }

        // This is an important code from the presepctive of missing numbers in 0-N. All numbers occupy their place and the number <0 or >N occupy themslves in the places of the missing numbers
        while (i <= nums.length - 1){
            int j = nums[i];
            if(nums[i] >=0 && nums[i] < len && nums[j] != nums[i]){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }else{
                i++;
            }
        }


//        int s1 = 0;
//        while (s1 <= len - 1){
//            if(nums[s1] >= 0)
//                nums[s1] = nums[s1] + min;
//            s1++;
//        }
//        System.out.println(Arrays.toString(nums));
//        return -1;

        int s = 0;
        while (s <= len - 1){
            nums[s] = nums[s] + min;
            if(nums[0] == 0){
                if(nums[s] == s) {
                    s++;
                }else {
                    return s;
                }
            }else if(nums[0] == 1){
                if(nums[s] == s+1) {
                    s++;
                }else {
                    return s+1;
                }
            }else {
                return 1;
            }
        }

        return nums[len - 1] + 1;

    }


    public static int getMinPositiveNumber(int[] nums){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] >=0 && nums[i]<min){
                min = nums[i];
            }
        }

        return min;
    }

}
