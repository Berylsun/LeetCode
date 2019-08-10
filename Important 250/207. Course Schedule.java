//V + E, n
class Solution {
    //BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int res = numCourses;
        
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            res--;
            for (int[] pair : prerequisites) {
                if (pair[1] == temp) {
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
