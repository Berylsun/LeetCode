/**
 * O(n)
 * O(n)
 */
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] down = new int[len];
        int[] up = new int[len];
        down[0] = 1;
        up[0] = 1;

        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }
        }

        return Math.max(down[len - 1], up[len - 1]);
    }
}

/**
 * O(n)
 * O(1)
 */
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int down = 1;
        int up = 1;

        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }

        return Math.max(down, up);
    }
}