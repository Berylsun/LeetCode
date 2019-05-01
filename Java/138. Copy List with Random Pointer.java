/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {return head;}
        Map<Node, Node> map = new HashMap<Node, Node>();        
        
        //1.copy values
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }
        
        //2.copy next&random
        Node noded = head;
        while (noded != null) {
            map.get(noded).next = map.get(noded.next);
            map.get(noded).random = map.get(noded.random);
            noded = noded.next;
        }
        return map.get(head);
    }
}
