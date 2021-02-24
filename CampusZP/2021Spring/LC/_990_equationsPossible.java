class Solution {
    /**
     * O(n)
     * O(1)
     * @param equations
     * @return
     */
    public boolean equationsPossible(String[] equations) {
        if (equations == null || equations.length == 0) return true;
        int n = equations.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (equations[l].charAt(1) == '=') {
                l++;
            } else {
                String tmp = equations[r];
                equations[r] = equations[l];
                equations[l] = tmp;
                r--;
            }
        }

        int[] nums = new int[26];
        for (int i = 0; i < 26; i++) {
            nums[i] = i;
        }
        for (String str : equations) {
            int c1 = str.charAt(0) - 'a';
            int c2 = str.charAt(3) - 'a';
            int x = findParent(nums, c1);
            int y = findParent(nums, c2);
            if (str.charAt(1) == '=') {
                nums[y] = x;
            } else {
                if (x == y) return false;
            }
        }
        return true;
    }

    public int findParent(int[] nums, int i) {
        if (nums[i] != i) {
            nums[i] = findParent(nums, nums[i]);
        }
        return nums[i];
    }
}