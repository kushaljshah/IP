package Educative.Patterns.CyclicSort;

import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2,6,4,3,1,5};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void cyclicSort(int[] nums){
        int i = 0;
        while (i < nums.length - 1){
            int j = nums[i] - 1;
            if(nums[j] != nums[i]){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }else{
                i++;
            }
        }

    }
}
