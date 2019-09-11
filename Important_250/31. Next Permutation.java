//n, 1  (题意难懂……)
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int firstSmall = -1;
       
        //end to start !!! 
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstSmall = i;
                break;
            }
        }
        if (firstSmall == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        //end to start !!!
        int firstLarge = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[firstSmall]) {
                firstLarge = i;
                break;
            }
        }
        swap(nums, firstLarge, firstSmall);
        
        //if not reverse, it will be biger than this !!!
        reverse(nums,firstSmall + 1, nums.length - 1);
    }
    
    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
