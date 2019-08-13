/*
  Given 2d vector =
     [
     [1,2],
     [3],
     [4,5,6]
     ]
     By calling next repeatedly until hasNext returns false,
     the order of elements returned by next should be: [1,2,3,4,5,6].
*/

int index;
int indexElement;
List<List<Integer>> list;
public _251_Flatten2DVector(List<List<Integer>> vec2d) {
    list = vec2d;
    index = 0;
    indexElement = 0;
}

public Integer next() {
    return list.get(index).get(indexElement++);
}

public boolean hasNext() {
    while (index < list.size()) {
        if (indexElement < list.get(index).size()) {
            return true;
        }else {
            index++;
            indexElement = 0;
        }
    }
    return false;
}
