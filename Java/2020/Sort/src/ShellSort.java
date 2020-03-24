import java.util.Arrays;

/**
 * time: O(n^(1.3—2))
 * space:O(1)
 *
 */
public class ShellSort {
    public static void shellSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int gap = nums.length;
        while (gap > 0) {
            gap /= 2;
            for (int i = 0; i < gap; i++) {
                // insertSort !!!
                for (int j = 0; j < nums.length - gap; j += gap) {
                    for (int k = j + gap; k >= gap; k -= gap) {
                        if (nums[k] < nums[k - gap]) {
                            int temp = nums[k - gap];
                            nums[k - gap] = nums[k];
                            nums[k] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 9, 4, 6, 2, 0};
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
