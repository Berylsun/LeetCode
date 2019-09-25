/* Given 2d vector =

     [
     [1,2],
     [3],
     [4,5,6]
     ]
     By calling next repeatedly until hasNext returns false,
     the order of elements returned by next should be: [1,2,3,4,5,6].

     time : O(n)
     space : O(1)
*/

List<List<Integer>> list;
int indexElement;
int indexList;

public _251_Flatten2DVector(List<List<Integer>> vec2d) {
    list = vec2d;
    indexElement = 0;
    indexList = 0;
}

//@Override
public Integer next() {
    return list.get(indexList).get(indexElement++);  // think easily !!!
}

//@Override
public boolean hasNext() {
    while (indexList < list.size()) {  //for judging indexList change !!!
        if (indexElement < list.get(indexList).size()) {
            return true;
        }else {
            indexList++;
            indexElement = 0;
        }
    }
    return false;
}
