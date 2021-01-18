class Solution {
    /**
     * Mergesort
     * O(nlogn)
     * O(n)
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        if (nums == null) return 0;
        int len = nums.length;
        if (len < 2) return 0;
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        return reversePairs(copy, 0, len - 1);
    }

    public int reversePairs(int[] nums, int l, int r) {
        if (l == r) return 0;
        int mid = l + (r - l) / 2;
        int left = reversePairs(nums, l, mid);
        int right = reversePairs(nums, mid + 1, r);

        int cross = merge(nums, l, mid, r);
        return left + right + cross;
    }

    public int merge(int[] nums, int l, int mid, int r) {
        int l1 = l;
        int l2 = mid + 1;
        int res = 0;
        int k = l;
        int[] temp = new int[r - l + 1];
        for (int i = 0; i < r - l + 1; i++) {
            temp[i] = nums[l + i];
        }
        while (l1 <= mid || l2 <= r) {
            if (l1 <= mid && l2 <= r) {
                if (temp[l1 - l] <= temp[l2 - l]) {
                    nums[k] = temp[l1 - l];
                    l1++;
                } else {
                    nums[k] = temp[l2 - l];
                    res += mid - l1 + 1;
                    l2++;
                }
            } else if (l1 > mid) {
                nums[k] = temp[l2 - l];
                l2++;
            } else {
                nums[k] = temp[l1 - l];
                l1++;
            }
            k++;
        }
        return res;
    }
}