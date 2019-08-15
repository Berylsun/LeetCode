//n, 1
DP!!!
public int numWays(int n, int k) {
    if (n == 0) return 0;
    if (n == 1) return k;
    
    int same = k;
    int diff = k * (k - 1);
    
    for (int i = 2; i < n; i++) {
        int temp = same;
        same = diff;
        diff = (diff + temp) * (k - 1);
    }
    return same + diff;
}


public int numWays(int n, int k) {
        if(n == 0) return 0;
        if(n == 1) return k;
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k*(k-1);
        int[] dp2 = new int[n];
        dp2[1] = k; 
        for(int i = 2; i < n; i++){
            dp2[i] = dp[i-1];
            dp[i] = (dp[i-1]+dp2[i-1])*(k-1);
        }
        return dp[n-1]+dp2[n-1];
    }
