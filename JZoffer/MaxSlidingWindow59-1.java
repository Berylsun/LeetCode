class Solution {
    /**
     * O(nk)
     * O(k)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            res[i] = findMax(nums, i, k);
        }
        return res;
    }

    public int findMax(int[] nums, int s, int k) {
        int res = nums[s];
        for (int i = s + 1 ; i < s + k; i++) {
            res = Math.max(res, nums[i]);
        }
        return res;
    }


    /**
     * O(n)
     * O(k)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0 ; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}