class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            int[][] a = new int[1][2];
            a[0][0] = newInterval[0];
            a[0][1] = newInterval[1];
            return a;
        } 
        int start = Integer.MIN_VALUE;
        int end = Integer.MAX_VALUE;
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= newInterval[0]) {
                start = Math.max(start, intervals[i][0]);
            }
            if (intervals[i][1] >= newInterval[1]) {
                end = Math.min(end, intervals[i][1]);
            }
        }
        if (start == Integer.MIN_VALUE) start = newInterval[0];
        if (end == Integer.MAX_VALUE) end = newInterval[1];
        
        int count = -1;
        int index = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (start == intervals[i][0]) {
                if (intervals[i][1] < newInterval[0]){
                    start = newInterval[0];
                } 
            }
            if (end == intervals[i][1]) {
                index = i + 1;
                //count += intervals.length - 1 - i;
                if (intervals[i][0] > newInterval[1]) {
                    end = newInterval[1];
                    index--;
                }                    
            }
        }
        int left = 0;
        while (left < intervals.length && intervals[left][1] < start) {
            res.add(intervals[left]);
            left++;
        }
        res.add(new int[]{start, end});
        while (index > -1 && index < intervals.length && intervals[index][0] > end) {
            res.add(intervals[index]);
            index++;
        }
        int[][] result = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            result[j] = res.get(j);
        }
        return result;
    }
}
