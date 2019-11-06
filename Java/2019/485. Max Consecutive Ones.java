class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int j=0,max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){j++;max=Math.max(max,j);}
            else{j=0;}
        }
        return max;
    }
}
