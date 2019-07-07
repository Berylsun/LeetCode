//time : O(edges * nodes)
//space : O(n)

1.Union Find
public boolean validTree(int n, int[][] edges) {
    if (n == 1 && edges.length == 0) return true;
    if (edges == null || n < 1 || edges.length != n - 1) return false;
    
    int[] root = new int[n];
    Arrays.fill(root, -1);
    
    for (int[] pair : edges) {
        int x = find(root, pair[0]);
        int y = find(root, pair[1]);
        if (x == y) return false;
        root[x] = y;
    }
    return true;
}

public int find(int[] root, int i) {
    while (root[i] != -1) {
        i = root[i];
    }
    return i;
}

2.Tree
public boolean validTree2(int n, int[][] edges) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
    }
    
    for (int[] pair : edges) {
        graph.get(pair[0]).add(pair[1]);
        graph.get(pair[1]).add(pair[0]);
    }
    
    HashSet<Integer> visited = new HashSet<>();
    visited.add(0);
    boolean res = helper(graph, visited, 0, -1);
    if (res == false) return false;
    return visited.size() == n ? true : false;
}

public boolean helper(List<List<Integer>> graph, HashSet<Integer> visited, int node, int parent) {
    List<Integer> sub = graph.get(node);
    for (int v : sub) {
        if (v == parent) continue;
        if (visited.contains(v)) return false;
        visited.add(v);
        boolean res = helper(graph, visited, v, node);
        if (!res) return false;
    }
    return true;
}

