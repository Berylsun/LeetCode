// V + E E = equations.length V = 2E（最多）, n
class Solution {
    HashMap<String, List<GraphNode>> map;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            if (!map.containsKey(list.get(0))) {
                map.put(list.get(0), new ArrayList<>());
            }
            map.get(list.get(0)).add(new GraphNode(list.get(1), values[i]));
            if (!map.containsKey(list.get(1))) {
                map.put(list.get(1), new ArrayList<>());
            }
            map.get(list.get(1)).add(new GraphNode(list.get(0), 1 / values[i]));
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = find(queries.get(i).get(0), queries.get(i).get(1), 1, new HashSet<>());
        }
        return res;
    }
    
    public double find(String start, String end, double value, HashSet<String> visited) {
        if (visited.contains(start)) return -1;
        if (!map.containsKey(start)) return -1;
        if (start.equals(end)) return value;
        visited.add(start);
        for (GraphNode next : map.get(start)) {
            double sub = find(next.den, end, value * next.val, visited);
            if (sub != -1) return sub;
        }
        visited.remove(start);
        return -1;
    }
    
    
    class GraphNode{
        double val;
        String den;
        GraphNode(String den, double val){
            this.den = den;
            this.val = val;
        }
    }
}
