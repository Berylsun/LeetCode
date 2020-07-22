/**
 * O(n)
 */
class Solution {

    Random rmd;
    int[] nums;

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
        int[] clones = nums.clone();
        for (int i = 0; i < clones.length; i++) {
            int idx = rmd.nextInt(i + 1);
            swap(clones, i, idx);
        }
        return clones;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */