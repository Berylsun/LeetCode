class Solution {
    /**
     * O(n)
     * O(n)
     * @param paths
     * @return
     */
    public String destCity(List<List<String>> paths) {
        String res = paths.get(0).get(0);
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < paths.size(); i++) {
            map.put(paths.get(i).get(0), paths.get(i).get(1));
        }
        while (map.containsKey(res)) {
            res = map.get(res);
        }
        return res;
    }
}