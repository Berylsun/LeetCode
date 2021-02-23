class LRUCache {
    class Node {
        Node pre;
        Node next;
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            if (node != tail) {
                if (node == head) {
                    head.next.pre = null;
                    head = head.next;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = tail.next;
            }

        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            if (node != tail) {
                if (node == head) {
                    head.next.pre = null;
                    head = head.next;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = tail.next;
            }
        } else {
            if (map.size() == capacity) {
                map.remove(head.key);
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    head.next.pre = null;
                    head = head.next;
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
                newnode.next = null;
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