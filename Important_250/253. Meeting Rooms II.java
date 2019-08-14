//nlogn, n
public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) {
        return 0;
    }
    
    int res = 0;
    int[] start = new int[intervals.length];
    int[] end = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
        start[i] = intervals[i].start;
        end[i] = intervals[i].end;
    }
    
    Arrays.sort(start);
    Arrays.sort(end);
    
    int j = 0; // end index;
    for (int i = 0; i < start.length; i++) {
        if (end[j] > start[i]) {
            res++;
        }else {
            j++;
        }
    }
    
    return res;
}

public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) return 0;
    Arrays.sort(intervals, (a, b) -> a.start - b.start);
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a.end - b.end);
    queue.offer(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
        Interval temp = queue.poll();
        if (intervals[i].start >= temp.end) {
            temp.end = intervals[i].end;
        }else {
            queue.offer(intervals[i]);
        }
        queue.offer(temp);
    }
    
    return queue.size();
}
