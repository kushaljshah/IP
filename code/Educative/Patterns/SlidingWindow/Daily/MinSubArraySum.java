package Educative.Patterns.SlidingWindow.Daily;


public class MinSubArraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum =0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            while (sum >= target){
                minLength = Math.min(minLength, ((i - start)+1));
                sum = sum - nums[start];
                start++;

            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }


    public static void main(String[] args) {

        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
        System.out.println(minSubArrayLen(7, new int[]{8}));
        System.out.println(minSubArrayLen(7, new int[]{8,0}));
        System.out.println(minSubArrayLen(7, new int[]{0,8}));

    }
}
