package LeetCode.Popular.Easy.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */


public class SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> counterMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            Integer count = counterMap.get(nums[i]);
            if(count == null)
                counterMap.put(nums[i], 1);
            else{
                counterMap.compute(nums[i], (k,v) -> v+1);
            }
        }

        System.out.println(counterMap);

        for (Map.Entry<Integer, Integer> entry: counterMap.entrySet()){
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return -1;
    }

    public int singleNumber2(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }



    public static void main(String[] args) {
        new SingleNumber().singleNumber2(new int[]{4,1,2,1,2});
    }

}
