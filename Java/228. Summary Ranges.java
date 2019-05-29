class Solution {
    public List<String> summaryRanges(int[] nums) {        
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int start = nums[0];
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                end = nums[i - 1];
                if (start == end) {
                    res.add(String.valueOf(start));
                }else {
                    res.add(start + "->" + end);
                }                
                start = nums[i];
            }
        }
        if (start == nums[nums.length - 1]) {
            res.add(String.valueOf(start));
        }else {
            res.add(start + "->" + nums[nums.length - 1]);
        }
        return res;
    }
}
