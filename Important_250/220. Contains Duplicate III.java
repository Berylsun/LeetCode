//nlogk, k
TreeSet!!!
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long)nums[i] + t);
            Long ceil = set.ceiling((long)nums[i] - t);
            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) {
                return true;
            }
            set.add((long)nums[i]);
            if (set.size() > k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}

//n, k
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long reMap = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = reMap / ((long)t + 1); //(0-3) t==3 include
            
            if (map.containsKey(bucket) 
                || (map.containsKey(bucket - 1) && reMap - map.get(bucket - 1) <= t) 
                || (map.containsKey(bucket + 1) && map.get(bucket + 1) - reMap <= t)) 
                return true;
            
            map.put(bucket, reMap);
            
            if (i >= k) {
                Long lastBucket = ((long)nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1);
                map.remove(lastBucket);
            }
            
        }
        return false;
    }
}
