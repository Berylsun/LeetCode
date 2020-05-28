class Solution {
    /**
     * O(n ^ 2)
     * O(n ^ 2)
     * @param N
     * @param dislikes
     * @return
     */
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];
        for (int[] d : dislikes) {
            graph[d[0] - 1][d[1] - 1] = 1;
            graph[d[1] - 1][d[0] - 1] = 1;
        }
        int[] group = new int[N];
        for (int i = 0; i < N; i++) {
            if (group[i] == 0 && !dfs(graph, group, i, 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int[] group, int index, int g) {
        group[index] = g;
        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i] == 1) {
                if (group[i] == g) {
                    return false;
                } else if (group[i] == 0 && !dfs(graph, group, i, -g)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * O(n)
     * O(n)
     * union find
     * @param N
     * @param dislikes
     * @return
     */
    public boolean possibleBipartition2(int N, int[][] dislikes) {
        int[] ids = new int[N+1];

        for(int[] x: dislikes) {
            int one = x[0];
            int two = x[1];

            if (ids[one] == 0 && ids[two] == 0) {
                ids[one] = two;
                ids[two] = one;
            }
            else if (ids[one] != 0 && ids[two] == 0) {
                ids[two] = ids[ids[one]];
            }
            else if (ids[one] == 0 && ids[two] != 0) {
                ids[one] = ids[ids[two]];
            }
            else if (ids[one] != 0 && ids[two] != 0 && ids[one] == ids[two]) {
                return false;
            }
        }
        return true;
    }
}