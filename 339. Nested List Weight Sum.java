//n, n
/*
    Example 1:
     Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
*/
//DFS
public int depthSum(List<NestedInteger> nestedList) {
    if (nestedList == null) return 0;
    return helper(nestedList, 1);
}

public int helper(List<NestedInteger> nestedList, int depth) {
    int res = 0;
    for (NestedInteger nest : nestedList) {
        if (nest.isInteger()) {
            res += nest.getInteger() * depth;
        }else {
            res += helper(nest.getList(), depth + 1);
        }
    }
    
    return res;
}

//BFS 
public int depthSum(List<NestedInteger> nestedList) {
    if (nestedList == null) return 0;
    int depth = 1;
    int res = 0;
    Queue<NestedInteger> queue = new LinkedList<>(nestedList); 
    
    while (!queue.isEmpty()) {
        itn size = queue.size();
        for (int i = 0; i < size; i++) {
            NestedInteger nest = queue.poll();
            if (nest.isInteger()) {
                res += nest.getInteger() * depth;
            }else {
                queue.addAll(nest.getList());
            }
        }
        depth++;
    }
    
    return res;
}
