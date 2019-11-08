class LRUCache {
    class Node {
        int val;
        int key;
        Node next;
        Node pre;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int capacity;
        
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        
        if (node != tail) {
            if (node == head) {
                head = node.next;               
            }else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            
            tail.next = node;
            node.pre = tail;
            node.next = null;
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
                    head = node.next;               
                }else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
            
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;            
            }
        }else {            
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            if (map.size() > capacity) {
                map.remove(head.key);
                head = head.next;
            }
            
            if (head == null && tail == null) {
                head = newNode;
            }else {
                tail.next = newNode;
                newNode.pre = tail;
            }
            newNode.next = null;
            tail = newNode;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
