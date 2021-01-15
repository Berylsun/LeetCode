class Solution {
    /**
     * O(V + E)
     * O(n)
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        int res = numCourses;
        for (int[] d : prerequisites) {
            degree[d[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            res--;
            for (int[] num : prerequisites) {
                if (num[1] == idx) {
                    degree[num[0]]--;
                    if (degree[num[0]] == 0) {
                        queue.offer(num[0]);
                    }
                }
            }
        }
        return res == 0;
    }
}