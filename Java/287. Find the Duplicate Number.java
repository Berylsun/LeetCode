//O(nlogn),O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int mid = 0;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            mid = (high - low) / 2 + low;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) count++;
            }
            if (count > mid) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
}


//O(n), O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
