import java.util.Arrays;

/**
 * time:
 * best:O(n)
 * worst:O(n^2)
 * average:O(n^2)
 * space:O(1)
 * stable: Yes
 *
 * LC 283
 */
public class BubbleSort {

    public static void bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp =  nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 12, 4, 6, 1};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
