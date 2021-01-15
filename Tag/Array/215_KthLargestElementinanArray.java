import java.util.PriorityQueue;

class Solution {
    /**
     * O(nlogn)
     * O(1)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int pos = partition(nums, l, r);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 < k) {
                l = pos + 1;
            } else {
                r = pos - 1;
            }
        }
        return -1;
    }

    public int partition(int[] nums, int l, int r) {
        int index = l;
        int pivot = nums[l];
        l++;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l, r);
                l++;
                r--;
            } else if (nums[l] >= pivot) {
                l++;
            } else {
                r--;
            }
        }
        swap(nums, index, r);
        return r;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    /**
     * O(nlogk)
     * O(k)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
