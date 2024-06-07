package LeetCode.Daily;

/**
 * 41. First Missing Positive
 * Hard
 * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
 *
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Explanation: The numbers in the range [1,2] are all in the array.
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Explanation: 1 is in the array but 2 is missing.
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * Explanation: The smallest positive integer 1 is missing.
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int missingPositive = -1;
        int length = nums.length;
        for(int i=0; i<length; i++){
            if(nums[i] >0 && nums[i] <= length){
                if(nums[nums[i] - 1] == nums[i] && nums[i] -1 == i){
                    continue;
                }
                else if(nums[nums[i] - 1] == nums[i] && nums[i] -1 != i){
                    nums[i] = 0;
                    i--;
                }else {
                    int tmp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = tmp;
                    i--;
                }
            }
        }

        for(int i=0; i<length; i++){
            if(nums[i] <=0 || nums[i] > length){
                missingPositive = i + 1;
                break;
            }
        }

        return missingPositive != -1 ? missingPositive : length + 1;
    }

    public static void main(String[] args) {
//        System.out.println(firstMissingPositive(new int[]{3,4,6,7}));
//        System.out.println(firstMissingPositive(new int[]{1,2,3,6,7}));
//        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
//        System.out.println(firstMissingPositive(new int[]{3,4,0,-1,1}));
//        System.out.println(firstMissingPositive(new int[]{3,4,0,1}));
//        System.out.println(firstMissingPositive(new int[]{3,4,0,2}));
//        System.out.println(firstMissingPositive(new int[]{1,2,3,4,5,6,7}));
//        System.out.println(firstMissingPositive(new int[]{1}));
//        System.out.println(firstMissingPositive(new int[]{2}));
//        System.out.println(firstMissingPositive(new int[]{1,2}));
//        System.out.println(firstMissingPositive(new int[]{2,3}));
        System.out.println(firstMissingPositive(new int[]{1,1,2}));
        System.out.println(firstMissingPositive(new int[]{2,2}));
        System.out.println(firstMissingPositive(new int[]{1,1,1,2,2,5}));
    }

}
