//O(m + n) m : nodes n : edges,   O(m)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

//DFS
class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        Node dup = new Node(node.val);
        dup.neighbors = new ArrayList<>();
        map.put(node, dup);
        for (Node neighbor : node.neighbors) {
            dup.neighbors.add(cloneGraph(neighbor));
        }
        return dup;
    }
}

//BFS
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        List<Node> nodes = getNodes(node);
        HashMap<Node, Node> map = new HashMap<>();
        for (Node cur : nodes) {
            map.put(cur, new Node(cur.val));
        }
        for (Node cur : nodes) {
            Node dup = map.get(cur);
            dup.neighbors = new ArrayList<>();
            for (Node neighbor : cur.neighbors) {
                dup.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
    
    public List<Node> getNodes(Node node) {
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
