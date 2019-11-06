int indexlist, indexelement;
List<List<Integer>> list;

public _251_Flatten2DVector(List<List<Integer>> vec2d) {
    indexlist = 0;
    indexelement = 0;
    list = vec2d;
}

public Integer next() {
    list.get(indexlist).get(indexelement++);
}

public boolean hasNext() {
    while (indexlist < list.size()) {
        if (indexelement < list.get(indexlist).size()) {
            return true;
        }else {
            indexelement = 0;
            indexlist++;
        }
    }
    return false;
}
