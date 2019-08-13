//n, n
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];
        while (i < intervals.length) {
            if (intervals[i][1] >= newInterval[0]) {
                break;
            }
            res.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        if (i == intervals.length) {
            res.add(new int[]{newInterval[0], newInterval[1]});
            return res.toArray(new int[][]{});
        }
        start = Math.min(intervals[i][0], newInterval[0]);
        while (i < intervals.length) {
            if (intervals[i][0] > newInterval[1]) {
                break;
            }
            end = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(new int[]{start, end});
        while (i < intervals.length) {
            res.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        
        return res.toArray(new int[][]{});
    }
}
