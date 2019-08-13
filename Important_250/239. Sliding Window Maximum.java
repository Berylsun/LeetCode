//n, n
class Solution {
    //Deque
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>(); //nums index
        
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == (i - k)) {
                deque.poll();
            }
            
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            
            deque.offer(i);
            
            if ((i + 1) >= k) {
                res[i + 1 - k] = nums[deque.peek()];
            }
        }
        
        return res;
    }
}
