class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid = (n - 1) / 2;
        int index = 0;
        int[] temp = new int[n];
        for (int i = 0; i <= mid; i++) {
            temp[index] = nums[mid - i];
            if (index + 1 < n) {
                temp[index + 1] = nums[n - 1 - i];
            }
            index += 2;
        }
        System.arraycopy(temp, 0, nums, 0, n);
/*
        public static void (Object src,
                             int srcPos,
                             Object dest,
                             int destPos,
                             int length)
src:源数组；	srcPos:源数组要复制的起始位置；
dest:目的数组；	destPos:目的数组放置的起始位置；	length:复制的长度。
*/
    }
}
