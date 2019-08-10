//V + E, n
class Solution {
    //BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res= new int[numCourses];
        int[] indegree = new int[numCourses];
        
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty() && index < numCourses) {
            int temp = queue.poll();
            res[index++] = temp;
            for (int[] pair : prerequisites) {
                if (pair[1] == temp) {
                    indegree[pair[0]]--;
                    if(indegree[pair[0]] == 0) {
                        queue.offer(pair[0]);
                    }
                }
            }
        }
        return index != numCourses ? new int[0] : res;
    }
}
