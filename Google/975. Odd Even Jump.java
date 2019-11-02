//logn, n
class Solution {
    /*
        DP + TreeMap
        boolean:
            higher[]
            lower[]
        TreeMap:
            ceilingEntry(larger than), floorEntry(smaller than)
            
            
    */
    public int oddEvenJumps(int[] A) {
        if (A == null || A.length == 0) return 0;
        //initialize
        int n = A.length;
        //logn
        TreeMap<Integer, Integer> map = new TreeMap<>();
        boolean[] higher = new boolean[n], lower = new boolean[n];
        
        higher[n - 1] = true;
        lower[n - 1] = true;
        map.put(A[n - 1], n - 1);
        int res = 1;
        
        for (int i = n - 2; i >= 0; i--) {
            Map.Entry hi = map.ceilingEntry(A[i]), lo = map.floorEntry(A[i]);
            
            if (hi != null) higher[i] = lower[(int)hi.getValue()]; 
            if (lo != null) lower[i] = higher[(int)lo.getValue()];
            if (higher[i]) res++; //cause the first jump is higher jump!!!
            map.put(A[i], i);            
        }
        
        return res;
    }
}
