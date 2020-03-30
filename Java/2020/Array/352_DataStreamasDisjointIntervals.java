class SummaryRanges {
    TreeMap<Integer, int[]> treeMap;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        treeMap = new TreeMap<>();
    }
    // time : O(logn)
    public void addNum(int val) {
        if (treeMap.containsKey(val)) return;
        Integer lowerKey = treeMap.lowerKey(val);
        Integer higherKey = treeMap.higherKey(val);
        if (lowerKey != null && higherKey != null && treeMap.get(lowerKey)[1] + 1 == val
                && val + 1 == treeMap.get(higherKey)[0]) {
            treeMap.get(lowerKey)[1] = treeMap.get(higherKey)[1];
            treeMap.remove(higherKey);
        } else if (lowerKey != null && val <= treeMap.get(lowerKey)[1] + 1) {
            treeMap.get(lowerKey)[1] = Math.max(treeMap.get(lowerKey)[1], val);
        } else if (higherKey != null && treeMap.get(higherKey)[0] - 1 == val) {
            treeMap.put(val, new int[]{val, treeMap.get(higherKey)[1]});
            treeMap.remove(higherKey);
        } else {
            treeMap.put(val, new int[]{val, val});
        }
    }

    public int[][] getIntervals() {
        List<int[]> list = new ArrayList<>(treeMap.values());
        return list.toArray(new int[][]{});
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */