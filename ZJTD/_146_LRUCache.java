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
                head = head.next;
                head.pre.next = null;
                head.pre = null;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            node.next = null;
            tail.next = node;
            node.pre = tail;
            tail = tail.next;

        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            if (map.size() == capacity) {
                map.remove(head.key);
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                    head.pre.next = null;
                    head.pre = null;
                }
            }
            Node newnode = new Node(key, value);
            map.put(key, newnode);
            if (head == null && tail == null) {
                head = newnode;
                tail = newnode;
            } else {
                tail.next = newnode;
                newnode.pre = tail;
                tail = tail.next;
            }
        } else {
            node.value = value;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                    head.pre = null;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                node.next = null;
                tail.next = node;
                node.pre = tail;
                tail = tail.next;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */