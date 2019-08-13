class Solution {
    public int dominantIndex(int[] nums) {
        int a=0;
        int[] res= new int[nums.length];
        for (int i=0;i<nums.length;i++){
            res[i]=nums[i];
        }      
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            if(res[i]==nums[nums.length-1]){
                a=i;
            }
        }
        if (nums.length==1){
            return 0;
        }
        if(nums[nums.length-2]*2>nums[nums.length-1]){
            return -1;
        }
        return a;
    }
}
