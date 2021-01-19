class Solution {
    /**
     * O(n)
     * O(n)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, true);
            } else {
                map.put(n, false);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (!entry.getValue()) {
                res = entry.getKey();
                break;
            }
        }
        return res;
    }


    /**
     * O(n)
     * O(1)
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] bits = new int[32];
        for (int n : nums) {
            int bitmask = 1;
            for (int i = 31; i >= 0; i--) {
                if ((n & bitmask) != 0) bits[i]++;
                bitmask <<= 1;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += bits[i] % 3;
        }
        return res;
    }
}