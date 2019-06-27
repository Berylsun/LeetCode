//V + E, n
//BFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }
        
        int res = numCourses;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            res--;
            for (int[] pair : prerequisites) {
                if (pair[1] == pre) {
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0) {
                        queue.offer(pair[0]);
                    }
                }
            }
        }
        return res == 0;
    }
}
