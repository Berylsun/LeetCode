/**
 * O(nlogn)
 * O(n)
 * insertSort
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int l = 0;
            int r = res;
            while (l < r) {
                int mid = (r - l) / 2 + l;
                if (tail[mid] < num) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            tail[l] = num;
            if (l == res) {
                res++;
            }
        }
        return res;
    }
}

/**
 * O(n^2)
 * O(n)
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}