class Solution {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int n = increase.length;
        int[][] nums = new int[n + 1][3];
        for (int i = 1; i < n + 1; i++) {
            nums[i][0] = nums[i - 1][0] + increase[i - 1][0];
            nums[i][1] = nums[i - 1][1] + increase[i - 1][1];
            nums[i][2] = nums[i - 1][2] + increase[i - 1][2];
        }
        int[] res = new int[requirements.length];
        for (int i = 0; i < requirements.length; i++) {
            int[] req = requirements[i];
            int l = 0;
            int r = n;
            while (l + 1 < r) {
                int mid = (r - l) / 2 + l;
                if (nums[mid][0] >= req[0] && nums[mid][1] >= req[1] && nums[mid][2] >= req[2]) {
                    r = mid;
                } else {
                    l = mid;
                }
            }

            if (nums[l][0] >= req[0] && nums[l][1] >= req[1] && nums[l][2] >= req[2]) {
                res[i] = l;
            } else {
                if (nums[r][0] < req[0] || nums[r][1] < req[1] || nums[r][2] < req[2]) {
                    r = -1;
                }
                res[i] = r;
            }
        }
        return res;
    }
}