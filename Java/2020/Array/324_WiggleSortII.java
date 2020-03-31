/**
 * O(nlogn)
 * O(n)
 */
class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] temp = new int[nums.length];
        int index = 0;
        int mid = (nums.length - 1) / 2;
        for (int i = 0; i <= mid; i++) {
            temp[index] = nums[mid - i]; // !!!
            if (index + 1 < nums.length) {
                temp[index + 1] = nums[nums.length - i - 1]; //!!!
            }
            index += 2;
        }
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }
}