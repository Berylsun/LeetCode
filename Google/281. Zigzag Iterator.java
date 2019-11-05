/*
Actually, the (next(), hasNext()) function of iterator points to the element in this place instead of next space !!!
*/


//O(n), O(1)
public class ZigzagIterator {
    private Iterator<Integer> i , j, temp;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        j = v1.iterator();
        i = v2.iterator();
    }

    public int next() {
        if (j.hasNext()){
            temp = j;
            j = i;
            i = temp;
        }
        
        return i.next();
    }

    public boolean hasNext() {
        return (j.hasNext() || i.hasNext());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
 
 //O(n), O(2)
 public class ZigzagIterator {
    private LinkedList<Iterator> list;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<>();
        if (!v1.isEmpty()) list.add(v1.iterator());
        if (!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        Iterator poll =  list.remove();
        int res = (Integer)poll.next(); //poll has already move to next element
        if (poll.hasNext()) {
            list.add(poll);
        }
        return res;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
