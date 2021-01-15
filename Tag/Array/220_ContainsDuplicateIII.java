/**
 * O(n * k)
 * O(1)
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length && j <= i + k; j++) {
                long a = nums[i]; // !!!
                long b = nums[j];
                if (Math.abs(a - b) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * time : O(nlogk)
 * space : O(k)
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums== null || nums.length == 0 || k < 1 || t < 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long)nums[i] + t); // >=, min
            Long ceil = set.ceiling((long)nums[i] - t); // <=, max

            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) {
                return true;
            }
            set.add((long)nums[i]);
            if (i >= k) {  //set.size() > k
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}