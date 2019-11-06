//n^2, n
class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int samePoint = 0;
            int sameXAxis = 1;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                        samePoint++;
                    }
                    if (points[i][0] == points[j][0]) {
                        sameXAxis++;
                        continue;
                    }
                    int up = points[i][1] - points[j][1];
                    int down = points[i][0] - points[j][0];
                    int gcd = gcd(up, down);
                    String s = (up / gcd) + "/" + (down / gcd);
                    map.put(s, map.getOrDefault(s, 1) + 1);
                    res = Math.max(res, map.get(s) + samePoint);
                }
            }
            res = Math.max(res, sameXAxis);
        }
        return res;
    }
    
    public int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
