//n^2, n^2
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // remove duplicate
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                //remove dulipcate in res area instead of others
                if (nums[i] + nums[l] + nums[r] == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++; // remove duplicate
                    while (l < r && nums[r] == nums[r - 1]) r--; // remove duplicate
                    l++;
                    r--;
                }else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                }else {
                    r--;
                }
            }
        }
        return res;
    }
}
