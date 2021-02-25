class Solution {
    /**
     * O(n! * n)
     * O(n)
     */
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        helper(nums, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue; //O(n)
            list.add(nums[i]);
            helper(nums, list);
            list.remove(list.size() - 1);
        }
    }

    /**
     * O(n!)
     * O(n)
     */
    class Solution {
        List<List<Integer>> res;
        public List<List<Integer>> permute(int[] nums) {
            res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            helper(nums.length, list, 0);
            return res;
        }

        public void helper(int n, List<Integer> list, int first) {
            if (first == n) {
                res.add(new ArrayList<>(list));
                return;
            }

            for (int i = first; i < n; i++) {
                Collections.swap(list, first, i);
                helper(n, list, first + 1);
                Collections.swap(list, first, i);
            }
        }
    }
}