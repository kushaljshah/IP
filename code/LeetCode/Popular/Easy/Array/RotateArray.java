package LeetCode.Popular.Easy.Array;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Follow up:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 */

public class RotateArray {

    public void rotate(int[] nums, int k) {
        int arrayLength = nums.length;
        int[] newArr = new int[arrayLength];

        for(int j=0; j<arrayLength; j++){
            int updatedIndex = j+k;
            if(updatedIndex < arrayLength){
                newArr[updatedIndex] = nums[j];
            }else{
                while(updatedIndex >= arrayLength){
                    updatedIndex = updatedIndex - arrayLength;
                }

                newArr[updatedIndex] = nums[j];
            }
        }

        for(int j=0; j<arrayLength; j++){
            nums[j] = newArr[j];
        }

    }

    public void rotate2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    public static void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }


    public static void rotate4(int[] nums, int k) {
        reverse(nums, 0, nums.length -1);
        if(nums.length > 1){
            reverse(nums, 0, (k - 1)%(nums.length -1));
            reverse(nums, k%(nums.length -1), nums.length -1);
        }
    }

    public static void reverse(int[] nums, int start, int end){
        while(end > start){
            int startValue = nums[start];
            int endValue = nums[end];
            int tmpValue = startValue;
            nums[start] = endValue;
            nums[end] = tmpValue;
            start++;
            end--;
        }

    }

    // Best approach
    public void rotate5(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse5(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }




    public static void main(String[] args) {
        rotate4(new int[] {1,2}, 1);
    }
}
