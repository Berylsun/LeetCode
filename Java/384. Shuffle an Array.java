class Solution {
    private int[] nums;
    private Random rdm;

    public Solution(int[] nums) {
        this.nums = nums;
        rdm = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null) return null;
        int[] clone  = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < nums.length; i++) {
            int random = rdm.nextInt(i + 1);
            swap(clone, i, random);
        }
        return clone;
    }
    
    public void swap(int[] clone, int i, int j) {
        int temp = clone[i];
        clone[i] = clone[j];
        clone[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
