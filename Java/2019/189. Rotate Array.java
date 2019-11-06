class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[]nums,int a,int b){
        int temp=0;
        while(a<b){
            temp=nums[a];
            nums[a]=nums[b];
            nums[b]=temp;
            a++;
            b--;
        }
    }
}




class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int j=0,b=k-1;
        int[]res=new int[nums.length];
        for(int i=k;i<nums.length;i++){
            res[i]=nums[j];
            j++;
        }
        for(int a=nums.length-1;a>nums.length-k-1;a--){
            res[b]=nums[a];
            b--;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=res[i];
        }
    }
}
