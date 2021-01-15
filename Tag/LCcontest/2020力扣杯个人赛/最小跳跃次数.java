class Solution {
    public int minJump(int[] jump) {
        int n = jump.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        int right = -1;
        Deque<Integer> deque = new LinkedList<>();  //distance
        deque.offer(0);
        while (!deque.isEmpty()) {
            int head = deque.pollFirst();
            // jump left
            while (right + 1 < head) {
                right++;
                if (dist[right] == -1) {
                    dist[right] = dist[head] + 1;
                    deque.addLast(right);
                }
            }

            int next = head + jump[head];
            if (next >= n) {
                return dist[head] + 1;
            }
            if (dist[next] == -1) {
                dist[next] = dist[head] + 1;
                deque.addLast(next);
            }
        }
        return -1;
    }
}