class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
        helper(nums, new ArrayList<>(), res);
        return res;
    }
    
    public void helper(int[] nums, List<Integer> temp, List<List<Integer>> res)
    {
        if(temp.size() == nums.length)
        {
            res.add(new ArrayList<>(temp)); //copy temp's val
            return;
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(temp.indexOf(nums[i]) == -1) //temp.indexOf(A) == -1 temp not contains A
            {
                temp.add(nums[i]);
                //set.add(nums[i]);
                helper(nums, temp, res);
                //set.remove(nums[i]);
                temp.remove(temp.size() - 1);// the val removed is same with set's
            }
        }   
    }
}
