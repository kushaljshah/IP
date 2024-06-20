package Educative.Patterns.MergeIntervals;

/**
 * Given an array arr of n elements that is first strictly increasing and then maybe strictly decreasing, find the maximum element in the array.
 *
 * Note: If the array is increasing then just print the last element will be the maximum value.
 *
 * Example:
 *
 * Input: array[]= {5, 10, 20, 15}
 * Output: 20
 * Explanation: The element 20 has neighbors 10 and 15, both of them are less than 20.
 *
 * Input: array[] = {10, 20, 15, 2, 23, 90, 67}
 * Output: 20 or 90
 * Explanation: The element 20 has neighbors 10 and 15, both of them are less than 20, similarly 90 has neighbors 23 and 67.
 */
public class PeakElement {

    /**
     * 10, 20, 15, 2, 23, 90, 67
     * 1 2 5 5 9
     * 4 5 9 12 12
     *
     */

    static int findPeak(int arr[], int n){
        int low = 0;
        int high = n - 1;
        int mid = low + (high - low)/2;
        while (low <= high){
            if ((mid == 0 || arr[mid - 1] <= arr[mid])
                    && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
                return mid;
            else if(mid > 0 && arr[mid - 1] > arr[mid])
                high = mid - 1;
            else
                low = mid + 1;

        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 20, 4, 1, 0 };
        int n = arr.length;
        System.out.println(
                "Index of a peak point is " + findPeak(arr, n));
    }

}
