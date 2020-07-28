import java.util.Arrays;

/**
 * time:
 * best:O(n)
 * worst:no meaning
 * average:O(n + k) k: the range of integer
 * space:O(k)
 * stabilization: yes
 *
 * LC 387
 */
public class CountingSort {
    public static void countingSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] != 0) {
                nums[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 9, 0, 4, 6, 2, 0, 2};
        countingSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
