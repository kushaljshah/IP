package LeetCode.Popular.Easy.Array;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

public class Intersection2Arrays {

    /**
     *
     * 1. Intialize array with size of m+n
     * 2. Fill first array value in resultant array by doing hashing(to find appropriate position)
     * 3. Repeat for second array
     * 4. While doing hashing if collision happens increment the position in recursive way
     */

    public void findPosition(int a[], int b[]) {
        int v = (a.length + b.length);
        int ans[] = new int[v];

        int zero1 = 0;
        int zero2 = 0;

        System.out.print("Intersection : ");
        // Iterate first array
        for (int i = 0; i < a.length; i++)
            zero1 = iterateArray(a, v, ans, i);

        // Iterate second array
        for (int j = 0; j < b.length; j++)
            zero2 = iterateArray(b, v, ans, j);

        int zero = zero1 + zero2;
        placeZeros(v, ans, zero);
        printUnion(v, ans, zero);

    }

    // Prints union of arr1[0..n1-1] and arr2[0..n2-1]
    private void printUnion(int v, int[] ans, int zero) {
        int zero1 = 0;
        System.out.print("\nUnion : ");
        for (int i = 0; i < v; i++) {
            if ((zero == 0 && ans[i] == 0) || (ans[i] == 0 && zero1 > 0))
                continue;
            if (ans[i] == 0)
                zero1++;
            System.out.print(ans[i] + ",");
        }
    }

    private void placeZeros(int v, int[] ans, int zero) {
        if (zero == 2) {
            System.out.println("0");
            int d[] = { 0 };
            placeValue(d, ans, 0, 0, v);
        }
        if (zero == 1) {
            int d[] = { 0 };
            placeValue(d, ans, 0, 0, v);
        }
    }

    // Function to itreate array
    private int iterateArray(int[] a, int v, int[] ans, int i) {
        if (a[i] != 0) {
            int p = a[i] % v;
            placeValue(a, ans, i, p, v);
        } else
            return 1;
        return 0;
    }

    private void placeValue(int[] a, int[] ans, int i, int p, int v) {
        p = p % v;
        if (ans[p] == 0)
            ans[p] = a[i];
        else {
            if (ans[p] == a[i])
                System.out.print(a[i] + ",");
            else {

                //Hashing collision happened increment position and do recursive call
                p = p + 1;
                placeValue(a, ans, i, p, v);
            }
        }
    }

    public static void main(String args[]) {
        int a[] = { 7, 1, 5, 2, 3, 6 };
        int b[] = { 3, 8, 6, 20, 7 };

        Intersection2Arrays uiu = new Intersection2Arrays();
        uiu.findPosition(a, b);
    }
}
