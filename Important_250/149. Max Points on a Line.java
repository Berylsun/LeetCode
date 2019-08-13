//n^2, n
class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length < 2) return points.length;
        int res = 0;
                
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int samePoint = 0;
            int sameX = 1;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    if (points[j][0] == points[i][0] && points[j][1] == points[i][1]){
                       samePoint++;
                    } 
                    if (points[j][0] == points[i][0]) {
                        sameX++;
                        continue;
                    } 
                    
                    int numerator = points[i][0] - points[j][0]; //分子
                    int denominator = points[i][1] - points[j][1]; //分母
                    int gcd = gcd(numerator, denominator);
                    String s = (denominator / gcd) + "/" + (numerator / gcd);
                    map.put(s, map.getOrDefault(s, 1) + 1);
                    res = Math.max(res, map.get(s) + samePoint);
                }                
            }
            res = Math.max(res, sameX);
        }
        return res;
    }
    
    public int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
