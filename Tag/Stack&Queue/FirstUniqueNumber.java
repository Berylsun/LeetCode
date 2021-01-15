class FirstUnique {
    class Node {
        Node pre;
        Node next;
        int val;
        public Node(int val) {
            this.val = val;
            pre = null;
            next = null;
        }
    }
    Queue<Integer> queue;
    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    public FirstUnique(int[] nums) {
        head = null;
        tail = null;
        map = new HashMap<>();
        queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int showFirstUnique() {
        return head == null ? -1 : head.val;
    }

    public void add(int value) {
        if (map.containsKey(value) && map.get(value) != null) {
            Node node = map.get(value);
            map.put(value, null);
            if (node == head) {
                head = head.next;
                if (node == tail) {
                    tail = null;
                }
            } else {
                if (node != tail) {
                    node.next.pre = node.pre;
                } else {
                    tail = node.pre;
                }
                node.pre.next = node.next;
            }
        } else if (!map.containsKey(value)) {
            Node newNode = new Node(value);
            if (head == null && tail == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                tail = newNode;
                tail.next = null;
            }
            map.put(value, newNode);
        }
        queue.offer(value);
    }
}

class FirstUnique2 {
    /**
     * LinkedHashSet order !!!
     */
    LinkedHashSet<Integer> set;
    HashMap<Integer, Boolean> map;
    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        set = new LinkedHashSet<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        while (!set.isEmpty()) {
            return set.iterator().next();
        }
        return -1;
    }

    public void add(int value) {
        if (map.containsKey(value)) {
            if (map.get(value)) {
                map.put(value, false);
                set.remove(value);
            }
        } else {
            map.put(value, true);
            set.add(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */