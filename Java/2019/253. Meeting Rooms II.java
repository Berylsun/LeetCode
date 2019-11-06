class solution {
    public int meeting (Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int res = 0;
        int end = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (starts[i] < ends[end]) {
                res++;
            }else{
                end++;
            }
        }
        return res;
    }
}


public int meeting (Interval[] intervals) {
    if (intervals == null || intervals.length == 0) {
            return 0;
        }
    int res = 0;
    Arrays.sort(intervals, (a, b) -> a.start - b.start);
    PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> a.end - b.end);
    for (int i = 0; i < intervals.length; i++) {
        Interval interval = heap.poll();
        if (intervals[i].start >= interval.end) {
            interval.end = intervals[i].end;
        }else {
            heap.offer(intervals[i]);
        }
        heap.offer(interval);
    }
    return heap.size();
}
