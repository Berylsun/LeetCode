class Solution {
    int[] sum;
    Random rmd;

    /**
     * O(n)
     * O(n)
     * @param w
     */
    public Solution(int[] w) {
        this.rmd = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.sum = w;
    }

    /**
     * O(nlogn)
     * O(1)
     * @return
     */
    public int pickIndex() {
        int index = rmd.nextInt(sum[sum.length - 1]) + 1;
        int l = 0;
        int r = sum.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (sum[mid] == index) {
                return mid;
            } else if (sum[mid] < index) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */