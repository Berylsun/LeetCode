class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0||nums==null){return 0;}
        Integer min=null;
        int sum=0,j=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>=s){
                min=min==null?(i-j+1):Math.min(min,i-j+1);
                sum-=nums[j];
                j++;
            }
        }
        return min==null?0:min;
    }
}
