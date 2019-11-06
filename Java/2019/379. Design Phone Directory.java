Queue<Integer> queue;
HashSet<Integer> set;
int maxNumbers;
public _379_DesignPhoneDirectory(int maxNumbers) {
    queue = new LinkedList<>();
    set = new Hashset<>();
    this.maxNumbers = maxNumbers;
    for (int i = 0; i < maxNumbers; i++) {
        queue.offer(i);
    }
}

public int get() {
    if (!queue.isEmpty()) {
        Integer res = queue.poll();
        set.add(res);
        return res;
    }
    return -1;
}

public boolean check(int number) {
    if (number < 0 || number >= maxNumber) return false;
    return !set.contains(number);
}

public void release(int number) {
    if (set.remove(number)) {
        queue.offer(number);
    }
}
