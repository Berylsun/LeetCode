//n, n
/*
    Example 1:
     Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)

     Example 2:
     Given the list [1,[4,[6]]], return 17.
     (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
*/

public int depthSumInverse(List<NestedInteger> nestedList) {
    int sum = 0;
    int res = 0;
    if (nestedList == null) return 0;
    while (!nestedList.isEmpty()) {
        List<NestedInteger> nestList = new ArrayList<>();
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                sum += nest.getInteger();
            }else {
                nestList.addAll(nest.getList());
            }
        }
        nestedList = nestList;
        res += sum;
    }
    
    return res;
}

public int depthSumInverse(List<NestedInteger> nestedList) {
    if (nestedList == null) return 0;
    return helper(nestedList, 0);
}

public int helper(List<NestedInteger> nestedList, int res) {
    List<NestedInteger> nestList = new ArrayList<>();
    
    for (NestedInteger nest : nestedList) {
        if (nest.isInteger) {
            res += nest.getInteger();
        }else {
            nestList.addAll(nest.getList());
        }
    }
    
    res += nestList.isEmpty() ? 0 : helper(nestList, res);
    
    return res;
}
