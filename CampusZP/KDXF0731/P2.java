package KDXF0731;
/*
9
25 84 21 47 15 27 68 35 20
[15, 20, 21, 25, 47, 27, 68, 35, 84]
[15, 20, 21, 25, 47, 27, 68, 35, 84]
[15, 20, 21, 25, 47, 27, 68, 35, 84]
[15, 20, 21, 25, 35, 27, 47, 68, 84]
[15, 20, 21, 25, 27, 35, 47, 68, 84]
[15, 20, 21, 25, 27, 35, 47, 68, 84]
 */

import java.util.*;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

public class P2 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        sort(nums, 0, n - 1);
    }

    public static void sort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums,left,right);
            System.out.println(Arrays.toString(nums));
            sort(nums, left, pivot - 1);
            sort(nums, pivot + 1,right);
        }

    }
    public static int partition(int[] nums, int left, int right) {
        int pivotIndex = left;
        int pivot = nums[pivotIndex];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] > pivot && nums[r] < pivot) {
                swap(nums,l++,r--);
            }
            if (nums[l] <= pivot) l++;
            if (nums[r] >= pivot) r--;
        }
        swap(nums, pivotIndex, r);
        return r;
    }

    public static void swap(int[]nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
