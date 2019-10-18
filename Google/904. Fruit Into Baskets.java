
/*
There are a row of trees, each tree grows one type of fruit. There may be trees grow the same fruit. For example, 4 trees in a row: apple tree, pear tree, apple tree, peach tree.

You have two baskets, try to pick as many fruits as possible to your basket. The basket can carry any quantity of fruit, but each basket can only carries one type of fruit. For example, one basket is for apple only, another one is for pear only, then you can not pick peach to any of your baskets.

You could start from any tree, then repeatedly perform the following steps:

Pick fruit from the tree to your baskets. If no basket available, stop.
Move to the next right tree. If there is no tree on the right, stop.
Note that once you start, you could not reselect the start tree: you must follow step 1, then step 2, then back to step 1, and so on until you stop.

What is the maximum amount of fruit you can collect?
*/

//Sliding Window
//n, 2
class Solution {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) return 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int j = 0;
        int count = 0;
        
        for (int i = 0; i < tree.length; i++) {
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
            while (map.size() > 2) {
                int num = map.get(tree[j]);
                map.put(tree[j], num - 1);
                if (map.get(tree[j]) == 0) {
                    map.remove(tree[j]);
                }
                j++;
            }
            count = Math.max(i - j + 1, count);
        }
        
        
        return count;
    }
}
