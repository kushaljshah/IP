package Educative.Patterns.TwoPointers;

import java.util.*;

public class MyKSum {

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(fourSum(new int[]{1,0,-1}, 0));
        System.out.println(fourSum(new int[]{-1,0,1,2,-1,-4}, 0));
        System.out.println(fourSum(new int[]{}, 0));
        System.out.println(fourSum(new int[]{0}, 0)); //Aflatoon case
        System.out.println(fourSum(new int[]{-3, 0, 1, 2, -1, 1, -2}, 0));
        System.out.println(fourSum(new int[]{-5, 2, -1, -2, 3}, 0));
        System.out.println(fourSum(new int[]{-2,0,0,2,2}, 0));
        System.out.println(fourSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}, 0));
        System.out.println(fourSum(new int[]{2,2,2,2,2}, 8));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();

        Arrays.sort(nums);
        return kSum(nums, target, 6, 0);
    }

    public static List<List<Integer>> kSum(int[] nums, int target, int k, int startElement) {
        List<List<Integer>> res = new ArrayList<>();


//        if (startElement == nums.length) {
//            return res;
//        }

        if(nums.length < k)
            return new ArrayList<>();

        if(k == 2)
            return twoSum(nums, startElement, target);

//        int average_value = target / k;
//
//        // We cannot obtain a sum of target if the smallest value
//        // in nums is greater than target / k or if the largest
//        // value in nums is smaller than target / k.
//        if  ((startElement < nums.length && nums[startElement] > average_value) || average_value > nums[nums.length - 1]) {
//            return res;
//        }


        for(int i = startElement; i< nums.length; i++){
//            if(i != startElement || i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }

            if (i == startElement || nums[i - 1] != nums[i]) {
                List<List<Integer>> entries = kSum(nums, target - nums[i], k - 1, i + 1);
                for (List<Integer> entry : entries) {
                    if (entry.size() > 0) {
                        List<Integer> resultEntry = new ArrayList<>();
                        resultEntry.add(nums[i]);
                        resultEntry.addAll(entry);
                        res.add(resultEntry);
                    }
                }
            }
        }

        return res;


    }

    public static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();

        int arrSize = nums.length;


        int first = start;
        int end = arrSize - 1;


        while (first < end){
            if(nums[first] + nums[end] == target){
                List<Integer> triplet = new ArrayList<>();
                triplet.add(nums[first]);
                triplet.add(nums[end]);
                result.add(triplet);
                first++;
                end--;

                // ALternate tho this is sort the triplet and add. check contains next time. Complexity would be same
                while (first < end && nums[first] == nums[first -1])
                    first++;

                while (first < end && nums[end] == nums[end +1])
                    end--;

            }else if(nums[first] + nums[end] < target){
                first++;
            }else {
                end--;
            }
        }


        return result;
    }
}
