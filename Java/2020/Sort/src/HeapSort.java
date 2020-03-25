import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void adjustHeap(int[] nums, int i, int len) {
        for (int j = i * 2 + 1; j < len; j = j * 2 + 1) {
            if (j + 1 < len && nums[j] < nums[j + 1]) {
                j++;
            }
            if (nums[j] > nums[i]) {
                swap(nums, j, i);
                i = j;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 8, 5, 9};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
