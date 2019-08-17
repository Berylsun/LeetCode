//logn, n
class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        large.add(num);
        small.add(large.poll());
        while (small.size() > large.size()) {
            large.add(small.poll());
        }
        
    }
    
    public double findMedian() {
        return small.size() == large.size() ? (small.peek() + large.peek()) / 2.0 : large.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
