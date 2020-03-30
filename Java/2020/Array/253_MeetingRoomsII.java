/**
 * O(nlogn)
 * O(n)
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int res = 0;
        int end = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[end]) {
                res++;
            } else {
                end++;
            }
        }
        return res;
    }
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = queue.poll();
            if (intervals[i][0] >= cur[1]) {
                cur[1] = intervals[i][1];
            } else {
                queue.offer(intervals[i]);
            }
            queue.offer(cur);
        }
        return queue.size();
    }
}