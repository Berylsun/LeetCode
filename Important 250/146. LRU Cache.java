//1
class LRUCache {
    class Node {
        int key;
        int val;
        Node pre;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }
    
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        tail = null;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        if (node != tail) {
            if (node == head) {
                head = head.next;
            }else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            node.next = null;
            node.pre = tail;
            tail.next = node;
            tail = node;
        }
        
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                }else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                node.next = null;
                node.pre = tail;
                tail.next = node;
                tail = node;
            }
        }else {
            Node newnode = new Node(key, value);
            if (map.size() == capacity) {
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
            }
            
            if (head == null && tail == null) {
                head = newnode;
            }else {
                newnode.next = null;
                newnode.pre = tail;
                tail.next = newnode;
            }
            tail = newnode;
            map.put(key, newnode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
