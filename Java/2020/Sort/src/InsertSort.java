import java.util.Arrays;

/**
 * time:
 * best:O(n)
 * worst:O(n^2)
 * average:O(n^2)
 * space:O(1)
 *
 */
public class InsertSort {
    public static void insertSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1 ; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 9, 4, 6, 2};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
