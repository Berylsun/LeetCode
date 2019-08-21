//n, n
public int size;
public Queue<Integer> queue;
int sum;
public _346_MovingAveragefromDataStream(int size) { 
    this.size = size;
    queue = new LinkedList<>();
    sum = 0;
}

public double next(int val) {
    queue.offer(val);
    sum += val;
    if (queue.size() > size) {
        sum -= queue.poll();
    }
    return (double)sum / queue.size();
}
