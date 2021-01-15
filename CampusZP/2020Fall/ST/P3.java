package ST;

import java.util.Arrays;

public class P3 {
    public static void main(String[] args) {
        int[][] nums = { {1,2}, {2,3}, {3,4}, {1,3} };
        int res = eraseOverlapIntervals(nums);
        System.out.println(res);
    }

    public static int eraseOverlapIntervals (int[][] intervals) {
        // write code here
        int res = 0;
        Arrays.sort(intervals, (a, b) -> (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));
        int i = 1;
        int end = intervals[0][1];
        while (i < intervals.length) {
            int[] interval = intervals[i];
            if (interval[0] < end) {
                res++;
            } else {
                end = interval[1];
            }
            i++;
        }
        return res;
    }
}
