class Solution {
    public int removeDuplicates(int[] nums) {
        /*int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[j]!=nums[i]){               
                j++; 
                nums[j]=nums[i];
            }
        }
        return j+1;*/
        int pos = 0;
        for(int num:nums) {
        	if(nums[pos]!=num) {
        		nums[++pos] = num; 
        	}
        }
        return pos+1;

        /*int j=0;
        if(nums.length-1>0){
            for(int i=0;i<(nums.length-1);i++){
                if(nums[i]!=nums[i+1]){
                    nums[j]=nums[i];
                    j++;    
                }
            }
            nums[j]=nums[nums.length-1];
            return j+1;
        }else{
            return 1;
        }*/
    }
}
