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
