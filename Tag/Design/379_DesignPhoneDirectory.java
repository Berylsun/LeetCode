class PhoneDirectory {

    int maxNumbers;
    HashSet<Integer> set;
    Queue<Integer> queue; //!!!!!!

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
        set = new HashSet<>();
        queue = new LinkedList<>();
        for (int i = 0; i < maxNumbers; i++) {
            queue.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (set.size() == maxNumbers) {
            return -1;
        }
        int res = queue.poll();
        set.add(res);
        return res;

    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !set.contains(number) && number < maxNumbers && number >= 0; //!!!!!!!
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (set.remove(number)) {  //!!!!!!!
            queue.add(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */