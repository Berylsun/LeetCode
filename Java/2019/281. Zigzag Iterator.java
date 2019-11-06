
Iterator<Integer> iterator i, j, temp;
public _281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    i = v2.iterator();
    j = v1.iterator();
}

public int next() {
    if (j.hasNext()) {
        temp = j;
        j = i;
        i = temp;
    }
    return i.next();
}

public boolean hasNext() {
    return i.hasNext() || j.hasNext();
}

//-------------------------------------------------------------

LinkedList<Iterator> list;
public _281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    list = new LinkedList<>();
    if (!v1.isEmpty()) list.add(v1.iterator());
    if (!v2.isEmpty()) list.add(v2.iterator());
}

public int next() {
    Iterator poll = list.remove();
    int res = (int) poll.next();
    if (poll.hasNext()) {
        list.add(poll);
    }
    return res;
}

public boolean hasNext() {
    return !list.isEmpty();
}
