class Solution {
    /**
     * O(nlogn)
     * O(n)
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}