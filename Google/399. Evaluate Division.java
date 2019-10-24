//time : O(V+E)
//space : O(n)

class Solution {
    class GraphNode{
        double val;
        String den;
        public GraphNode(String den, double val) {
            this.val = val;
            this.den = den;
        }
    }
    
    HashMap<String, List<GraphNode>> map;
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> pair = equations.get(i);
            
            if (!map.containsKey(pair.get(0))) {
                map.put(pair.get(0), new ArrayList<>());
            }
            map.get(pair.get(0)).add(new GraphNode(pair.get(1), values[i]));
            
            if (!map.containsKey(pair.get(1))) {
                map.put(pair.get(1), new ArrayList<>());
            }
            map.get(pair.get(1)).add(new GraphNode(pair.get(0),1 / values[i]));
        }
        
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = helper(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), 1);
        }
        
        return res;
    }
    
    //backtracking
    public double helper(String a, String b, HashSet<String> visited, double val) {
        if (!map.containsKey(a)) return -1;
        if (visited.contains(a)) return -1;
        
        if (a.equals(b)) return val;
        
        visited.add(a);
        for (GraphNode next : map.get(a)) {
            double num = helper(next.den, b, visited, next.val * val);
            if (num != -1) {
                return num;
            }
        }
        visited.remove(a);
        return -1;
    }
        
        
}
