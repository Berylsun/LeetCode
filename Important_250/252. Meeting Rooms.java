//
/*
  For example,
     Given [[0, 30],[5, 10],[15, 20]],
     return false.
*/
public boolean canAttendMeetings(Interval[] intervals) {
    Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
    for (int i = 1; i < intervals.length; i++) {
        if (intervals[i - 1].end > intervals[i].start) {
            return false;
        }
    }
    return true;
}
