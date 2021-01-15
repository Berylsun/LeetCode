/**
 * O(nlogn)
 * O(n)
 */
class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> (b - a));
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        large.offer(num);
        small.offer(large.poll());  //!!!
        while (small.size() > large.size()) {
            large.offer(small.poll());
        }
    }

    public double findMedian() {
        return small.size() == large.size() ? (double)(small.peek() + large.peek()) / 2 : large.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */