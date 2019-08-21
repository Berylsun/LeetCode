class SummaryRanges {
    TreeMap<Integer, int[]> map;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    //logn
    public void addNum(int val) {
        if (map.containsKey(val)) return;
        Integer lowKey = map.lowerKey(val);
        Integer highKey = map.higherKey(val);
        
        if (lowKey != null && highKey != null && map.get(lowKey)[1] == val - 1 && val + 1 == map.get(highKey)[0]){
            map.get(lowKey)[1] = map.get(highKey)[1];
            map.remove(highKey);
        }else if (lowKey != null && val <= map.get(lowKey)[1] + 1) {
            map.get(lowKey)[1] = Math.max(val, map.get(lowKey)[1]);
        }else if (highKey != null && val + 1 == map.get(highKey)[0]) {
            map.put(val, new int[] {val, map.get(highKey)[1]});
            map.remove(highKey);
        }else {
            map.put(val, new int[]{val, val});
        }
    }
    
    public int[][] getIntervals() {
        List<int[]> list = new ArrayList<>(map.values());
        int[][] res = new int[map.size()][2];
        for (int i = 0; i < map.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
