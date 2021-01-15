class Solution {
    /**
     * O(n^2)
     * O(n)
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    public boolean helper(int[] nums, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (nums[p] < nums[j]) p++;
        int m = p;
        while (nums[p] > nums[j]) p++;
        return p == j && helper(nums, i, m - 1) && helper(nums, m, j - 1);
    }


    /**
     * O(n)
     * O(n)
     * @param postorder
     * @return
     */
    public boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }
}