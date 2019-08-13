//O(m + n) m : nodes n : edges
//O(m)
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
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        map.put(node, new Node(node.val));
        map.get(node).neighbors = new ArrayList<>();
        for (Node cur : node.neighbors) {            
            map.get(node).neighbors.add(cloneGraph(cur));
        }
        return map.get(node);
    }
}
