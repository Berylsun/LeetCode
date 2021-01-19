class Solution {
    /**
     * O(mlogn) m = n^2
     * O(m = n^2)
     * 最小生成树
     * Kruskal + Unionfind
     * @param points
     * @return
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] uf = new int[n];
        for (int i = 0;i < n; i++) {
            uf[i] = i;
        }

        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                list.add(new Edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }
        Collections.sort(list, (a, b) -> a.len - b.len);

        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            Edge e = list.get(i);
            int x = findParent(uf, e.a);
            int y = findParent(uf, e.b);
            if (x != y) {
                uf[y] = x;
                res += e.len;
            }
        }
        return res;
    }

    public int findParent(int[] nums, int i) {
        if (nums[i] != i) {
            nums[i] = findParent(nums, nums[i]);
        }
        return nums[i];
    }
}

class Edge {
    int a;
    int b;
    int len;
    public Edge (int a, int b, int len) {
        this.a = a;
        this.b = b;
        this.len = len;
    }
}