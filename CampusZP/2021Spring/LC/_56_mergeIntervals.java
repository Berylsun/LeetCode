class Solution {
    /**
     *O(nlogn)
     * O(logn) sort space
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) return null;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int len = intervals.length;
        int start = intervals[0][0];
        int end = intervals[0][1];
        int i = 0;
        while (i < len) {
            if (intervals[i][0] > end) {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else if (intervals[i][1] > end) {
                end = intervals[i][1];
            }
            i++;
        }
        res.add(new int[]{start, end}); //!!!
        return res.toArray(new int[res.size()][2]);
    }
}