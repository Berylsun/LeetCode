class MaxQueue {
    Deque<Integer> dq;
    Queue<Integer> q;
    public MaxQueue() {
        dq = new LinkedList<>();
        q = new LinkedList<>();
    }

    public int max_value() {
        if (q.isEmpty()) {
            return -1;
        }
        return dq.peekFirst();
    }

    public void push_back(int value) {
        while (!dq.isEmpty() && dq.peekLast() < value) {
            dq.pollLast();
        }
        dq.offerLast(value);
        q.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        if (dq.peekFirst().equals(q.peek())) {   // Integer not int !!!!
            dq.pollFirst();
        }
        return q.poll();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */