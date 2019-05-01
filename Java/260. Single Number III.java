class Solution {
    public int[] singleNumber(int[] nums) {
        int val=0;
        for(int i=0;i<nums.length;i++){
            val^=nums[i];
        }
        val&=-val;
        int[]res={0,0};
        for(int i=0;i<nums.length;i++){
            if((val&nums[i])==0){
                res[0]^=nums[i];
            }else{
                res[1]^=nums[i];
            }
        }
        return res;
    }
}

