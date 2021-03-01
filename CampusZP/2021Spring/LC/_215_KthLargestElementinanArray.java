class Solution {
    /**
     * O(nlogn)
     * O(1)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return -1;
        int l = 0;
        int r = nums.length - 1;
        while (true) {
            int pos = findPos(nums, l, r);
            if (pos + 1 == k) return nums[pos];
            if (pos + 1 < k) {
                l = pos + 1;
            } else {
                r = pos - 1;
            }
        }
    }
    public int findPos(int[] nums, int l, int r) {
        int p = l;
        int num = nums[p];
        l++;
        while (l <= r) {
            if (nums[l] < num && nums[r] > num) {
                swap(nums, l, r);
                l++;
                r--;
            } else if (nums[r] <= num) {
                r--;
            } else {
                l++;
            }
        }
        swap(nums, r, p);
        return r;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public int findKthLargest(int[] nums, int k) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            heapAdjust(nums, i, nums.length);
        }

        for (int i = nums.length - 1; i > nums.length - k; i--) {
            swap(nums, 0, i);
            heapAdjust(nums, 0,i);
        }
        return nums[0];
    }

    /**
     * O(nlogn)
     * O(logn)
     * heapsort  max-heap
     * A[0] top of heap
     * @param nums
     * @param start
     * @param length
     */
    public static void heapAdjust(int[] nums, int start, int length) {
        int child = 2 * start + 1;
        while (child < length) {
            if (child + 1 < length && nums[child] < nums[child + 1]) {
                child++;
            }
            if (nums[start] < nums[child]) {
                swap(nums, start, child);
            }else {
                break;
            }
            start = child;
            child = 2 * child + 1;
        }
    }
}