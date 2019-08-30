class Solution {
    int[] nums;
    Random rmd;
    public Solution(int[] nums) {
        this.nums = nums;
        rmd = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] clone = nums.clone();
        for (int i = 0; i < clone.length; i++) {
            int num = rmd.nextInt(i + 1);
            swap(clone, i, num);
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
