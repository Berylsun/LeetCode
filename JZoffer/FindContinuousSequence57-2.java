class Solution {
    /**
     * O(n^2)
     * O(1)
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < target; i++) {
            int sum = 0;
            for (int j = i; j < target; j++) {
                sum += j;
                if (sum == target) {
                    int[] list = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        list[k - i] = k;
                    }
                    res.add(list);
                    break;
                }
                if (sum > target) {
                    break;
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    /**
     * O(n)
     * O(1)
     * sliding window
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int l = 1;
        int r = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while (l <= target / 2) {
            if (sum < target) {
                sum += r;
                r++;
            } else if (sum > target) {
                sum -= l;
                l++;
            } else {
                int[] list = new int[r - l];
                for (int i = l; i < r; i++) {
                    list[i - l] = i;
                }
                res.add(list);
                sum -= l;
                l++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}