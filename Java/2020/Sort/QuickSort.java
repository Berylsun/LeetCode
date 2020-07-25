import java.util.Arrays;

/**
 * time:
 * best:O(nlogn)
 * worst:O(n^2)
 * average:O(nlogn)
 * space:O(logn-n)
 * stabilization: no
 *
 * LC 215
 */
public class QuickSort {
    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivotindex = left;
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            if (nums[i] > pivot && nums[j] < pivot) {
                swap(nums, i, j);
                i++;
                j--;
            } else if (nums[i] <= pivot) {
                i++;
            } else if (nums[j] >= pivot) {
                j--;
            }
        }
        swap(nums, pivotindex, j);
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 9, 4, 6, 2, 0};
        quickSort(nums,0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
