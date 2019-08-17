//nlogn, n
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        int res = 0;
        int[] tail = new int[nums.length];
        
        for (int num : nums) {
            int i = 0;
            int j = res;
           while (i + 1 < j) {
                int mid = (i + j) / 2;
                if (tail[mid] < num) {
                    i = mid;
                } else {
                    j = mid;
                }
            }
            j = tail[i] >= num ? i : j;
            
            tail[j] = num;
            if (j == res) ++res;
        }
        
        return res;
    }
}
