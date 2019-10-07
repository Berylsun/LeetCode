//1
class LRUCache {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
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
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        if (node != tail) {
            if (node ==  head) {
                head = head.next;
            }else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }
        
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            //set
            Node node = map.get(key);
            node.value = value;
            if (node != tail) {
                if (node ==  head) {
                    head = head.next;
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
            //insert
            //remove the least recently used item
            if (map.size() == capacity) {
                map.remove(head.key);
                head = head.next;
            }
            Node newNode = new Node(key, value);
            
            if (head == null && tail == null) {
                head = newNode;                
            }else {
                tail.next = newNode;
                newNode.pre = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
