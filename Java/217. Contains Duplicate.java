class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for(int i:nums){
            res.add(i);
        }
        return res.size()!=nums.length;
    }
}
