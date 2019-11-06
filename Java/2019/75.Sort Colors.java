class Solution {
        public void sortColors(int[] nums) {
            int start = 0;
            int index = 0;
            int end = nums.length - 1;
            for (int num: nums) {
                if(nums[index] == 0) {
                    swap(nums, index++, start++);
                }else if (nums[index] == 1) {
                    index++;
                }else{
                    swap(nums, index, end--);
                }
            }
            return;
        }
        public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
