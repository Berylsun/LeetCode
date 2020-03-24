import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * time:
 * n : 待排序数据 m: 桶
 * best:O(n)
 * worst:no meaning
 * average:O(n + c)  c = n * (logn -> logm)
 * space:O(n + m)
 *stabilization: yes
 *
 * LC 347
 */
public class BucketSort {
    public static void bucketSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int bucketNum = (max - min) / nums.length + 1;
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<>());
        }

        for (int i = 0; i < nums.length; i++) {
            int num = (nums[i] - min) / nums.length;
            bucket.get(num).add(nums[i]);
        }

        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(bucket.get(i));
        }
        System.out.println(bucket.toString());
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 9, 0, 4, 6, 2, 0, 2};
        bucketSort(nums);
    }

}
