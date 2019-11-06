class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(list, nums[i]);
            res[i] = index;
            list.add(index, nums[i]);
        }
        return Arrays.asList(res); //（）需要是对象，所以最初设Integer[]res, 而不是int[]res.
    }
    
    public int findIndex(List<Integer> list, int num) {
        if (list.size() == 0) return 0;
        int i = 0;
        int j = list.size() - 1;
        if (list.get(i) >= num) return 0;
        if (list.get(j) < num) return j + 1;
        while (i < j) {
            int mid = (j - i) / 2 + i;
            if (list.get(mid) < num) {
                i = mid + 1;
            }else {
                j = mid;
            }
        }
        return i;
    }
}
