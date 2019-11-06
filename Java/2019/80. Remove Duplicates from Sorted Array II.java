class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 2;
        for (int i = 2; i <nums.length; i++) {
            if(nums[i] != nums[count - 2]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}



class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        int res = 0;
        int val = 0;
        int count = 0;
        while(i < nums.length) {
            val = nums[i];
            while (i < nums.length && nums[i] == val) {
                count++;
                i++;
            }
            if (count < 2) {
                nums[res++] = val;
                count--;               
            }else {
                count = 2;
                while (count != 0){
                    nums[res++] = val;
                    count--; 
                }
                
            }           
        }
        return res;
    }
}
