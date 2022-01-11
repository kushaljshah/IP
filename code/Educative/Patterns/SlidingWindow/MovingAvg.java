package Educative.Patterns.SlidingWindow;

/**
 *
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 *
 * Let’s understand this problem with a real input:
 *
 * Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
 * Here, we are asked to find the average of all contiguous subarrays of size ‘5’ in the given array. Let’s solve this:
 *
 * For the first 5 numbers (subarray from index 0-4), the average is: (1+3+2+6-1)/5 => 2.2(1+3+2+6−1)/5=>2.2
 * The average of next 5 numbers (subarray from index 1-5) is: (3+2+6-1+4)/5 => 2.8(3+2+6−1+4)/5=>2.8
 * For the next 5 numbers (subarray from index 2-6), the average is: (2+6-1+4+1)/5 => 2.4(2+6−1+4+1)/5=>2.4
 * …
 * Here is the final output containing the averages of all contiguous subarrays of size 5:
 *
 * Output: [2.2, 2.8, 2.4, 3.6, 2.8]
 *
 */

/**
 * IMP
 */


public class MovingAvg {

    public static void main(String[] args) {
        int[] nums;
        nums = new int[] {0,4,0,3,2};

        System.out.println(avgOptimized(nums));
    }

    public static double avg(int[] nums){
        int k = 93;

        if(nums == null || nums.length == 0 || k == 0)
            return 0;

        double avg = 0;

        for(int i=0; i<nums.length; i++){
            double sum = 0;
            if(k+i > nums.length)
                break;

            for(int j=i; j<k+i; j++){
                sum = sum + nums[j];
            }

            if(avg == 0 || sum/k > avg)
                avg = sum/k;
        }

        return avg;

    }

    public static double avgOptimized(int[] nums){
        int k = 1;

        if(nums == null || nums.length == 0 || k == 0)
            return 0;

        double avg = 0;
        double newAvg = 0;
        double sum = 0;
        int firstIndex = 0;

        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];

            if(i == k - 1)
                avg = sum/k;

            if(i >= k){
                sum = sum - nums[firstIndex];
                newAvg = (sum)/k;
                if(newAvg > avg)
                    avg = newAvg;

                firstIndex++;

            }

        }

        return avg;
    }



}
