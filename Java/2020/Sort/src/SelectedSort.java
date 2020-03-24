import java.util.Arrays;

/**
 * time:
 * best:O(n^2)
 * worst:O(n^2)
 * average:O(n^2)
 * space:O(1)
 * stabilization: no
 *
 * LC 334
 */
public class SelectedSort {
    public static void selectedSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length; i++) {
            int minindex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[minindex] > nums[j]) {
                    minindex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minindex];
            nums[minindex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{12, 3, 4, 1, 6, 5};
        selectedSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
