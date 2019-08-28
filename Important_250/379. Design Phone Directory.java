/*
   get: Provide a number which is not assigned to anyone.
   check: Check if a number is available or not.
   release: Recycle or release a number.
*/

Queue<Integer> queue;
HashSet<Integer> used;
int maxNumbers;

public DesignPhoneDirectory(int maxNumbers) {
    queue = new LinkedList<>();
    used = new HashSet<>();
    this.maxNumber = maxNumber;
    
    for (int i = 0; i < maxNumber; i++) {
        queue.offer(i);
    }
}

public int get() {
    if (queue.isEmpty()) {
        return -1;
    }
    int res = queue.poll();
    used.add(res);
    return res;
}

public boolean check(int num) {
    if (num < 0 || nums >= maxNumber) {
        return false;
    }
    
    return !used.contains(num);
}

public void release(int num) {
    if (used.remove(num)) {
        queue.offer(num);
    }
}
