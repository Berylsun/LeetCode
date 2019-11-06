//n, n
Queue<Integer> queue;
int size;
double sum = 0;
public _346_MovingAveragefromDataStream(int size) {
    this.size = size;
    queue = new LinkedList<>();
}

public double next(int val) {
    if (queue.size() == size) {        
        sum -= queue.remove();
    }
    sum += val;
    queue.offer(val);
    return sum / queue.size();
}
