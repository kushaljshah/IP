package LeetCode.Daily;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * Example 3:
 *
 * Input: nums = [3,3,3,3,3]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 */
public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        int duplicateNumber = -1;
        for (int i=0; i<nums.length; i++){
            if(nums[i] == nums[nums[i] - 1]){
                if(i != nums[i] - 1){
                    duplicateNumber = nums[i];
                }
            } else {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
                i--;
            }
        }

        return duplicateNumber;

    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1}));
    }
}
