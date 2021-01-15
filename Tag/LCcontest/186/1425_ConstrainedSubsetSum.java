class Solution {
    /**
     * O(n)
     * O(k)
     * @param nums
     * @param k
     * @return
     */
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i > k && !deque.isEmpty() && deque.peekFirst() == nums[i - k - 1]) {
                deque.pollFirst();
            }
            nums[i] += !deque.isEmpty() ? deque.peekFirst() : 0;
            res = Math.max(res, nums[i]);

            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            //!!!!!
            if (nums[i] > 0) {
                deque.offer(nums[i]);
            }

        }
        return res;
    }
}