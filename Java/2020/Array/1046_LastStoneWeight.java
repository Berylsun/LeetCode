class Solution {
    public int lastStoneWeight(int[] stones) {
        return helper(stones, 0, stones.length);
    }
    public int helper(int[] stones, int start, int end) {
        if (end <= 0) return 0;
        if (end == 1) return stones[0];
        Arrays.sort(stones, start, end);
        int max1 = stones[end - 1];
        int max2 = stones[end - 2];
        if (max1 == max2) {
            return helper(stones,0, end - 2);
        } else {
            stones[end - 2] = max1 - max2;
            return helper(stones, 0, end - 1);
        }
    }

    /**
     * PriorityQueue
     * @param A
     * @return
     */
    public int lastStoneWeight2(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
        for (int a : A)
            pq.offer(a);
        while (pq.size() > 1)
            pq.offer(pq.poll() - pq.poll());
        return pq.poll();
    }
}