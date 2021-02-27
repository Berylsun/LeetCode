class Solution {
    /**
     * O(nlogn)
     * O(n)
     * @param arr
     * @param target
     * @return
     */
    public int findBestValue(int[] arr, int target) {
        if (arr == null || arr.length == 0) return 0;
        Arrays.sort(arr);
        int len = arr.length;
        int max = arr[len - 1];
        int l = 0;
        int r = max;
        int[] pre = new int[len];
        pre[0] = arr[0];
        for (int i = 1; i < len; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }
        while (l + 1 < r) {
            int mid = (r - l) / 2 + l;
            int num = findTotal(arr, mid);
            if (num < target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (Math.abs(findTotal(arr, l) - target) <= Math.abs(findTotal(arr, r) - target)) {
            return l;
        }
        return r;
    }

    public int findTotal(int[] arr, int i) {
        int res = 0;
        for (int a : arr) {
            if (a > i) {
                res += i;
            } else {
                res += a;
            }
        }
        return res;
    }
}