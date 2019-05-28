class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return intervals;
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 1;
        int start = 0;
        int end = 0;
        
       Arrays.sort(intervals, 
                    new Comparator<int[]>() {
                       @Override 
                       public int compare(int[] a, int[] b) {
                           return Integer.compare(a[0], b[0]);
                       }
                    }
        );
        
        
        while (j < intervals.length) {
            if (intervals[i][1] < intervals[j][0]) {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }else{
                while (j < intervals.length && intervals[i][1] >= intervals[j][0]) {
                    start = intervals[i][0];
                    end = Math.max(intervals[j][1], intervals[i][1]);                                         intervals[j] = new int[]{start, end};
                    i = j;
                    j++;
                }
                list.add(new int[]{start, end});
            }            
            i++;
            j++;
        }
        if (list.get(list.size() - 1)[1] < intervals[intervals.length - 1][0]) {
            list.add(new int[]{intervals[intervals.length - 1][0], intervals[intervals.length - 1][1]});
        }
        int[][] res = new int[list.size()][2];
        for (int a = 0; a < list.size(); a++) {
            res[a] = list.get(a);
        }
        return res;
    }
}
