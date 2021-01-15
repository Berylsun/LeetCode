class Solution {
    /**
     * O(nlogn)
     * O(1)
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        for (int[] cur : people) {
            res.add(cur[1], cur);
        }
        return res.toArray(new int[][]{});
    }
}