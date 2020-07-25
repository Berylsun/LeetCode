import java.util.Arrays;

/**
 * time:
 * best:O(nlogn)
 * worst:O(nlogn)
 * average:O(nlogn)
 * space:O(n)
 * stabilization: Yes
 *
 * LC 88
 */
public class MergeSort {
    public static void mergeSort(int[] nums, int left, int right) {
        int mid = (right - left) / 2 + left;
        if (left < right) {
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }


    public static  void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int idx = 0;
        while (idx < temp.length) {
            if (i > mid) {
                temp[idx] = nums[j++];
            } else if (j > right) {
                temp[idx] = nums[i++];
            } else if (nums[i] < nums[j]) {
                temp[idx] = nums[i++];
            } else {
                temp[idx] = nums[j++];
            }
            idx++;
        }
        for (int k = left; k <= right ; k++) {
            nums[k] = temp[k - left];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 9, 4, 6, 2};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
