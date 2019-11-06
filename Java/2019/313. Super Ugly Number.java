//O(n * logk), O(max(n,k))
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (primes == null || primes.length == 0) return 0;
        int[] res = new int[n];
        res[0] = 1;
        PriorityQueue<Num> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < primes.length; i++) {
            pq.offer(new Num(primes[i], 1, primes[i]));
        }
        
        for (int i = 1; i < n; i++) {
            res[i] = pq.peek().val;
            while (pq.peek().val == res[i]){
                Num temp = pq.poll();
                pq.offer(new Num(temp.prime * res[temp.index], temp.index + 1, temp.prime)); 
            }            
        }        
        return res[n - 1];
    }
    
    class Num{
        int val;
        int index; 
        int prime;
        Num(int val, int index, int prime) {
            this.val = val;
            this.index = index;
            this.prime = prime;
        }
    }
}
