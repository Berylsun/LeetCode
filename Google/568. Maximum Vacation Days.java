//     time : O(K * N * N)
//     space : O(n)
class Solution {
    //DP!!!
    /*
    if we don't add Arrays.fill(xxx, Integer.MIN_VALUE) 
        [[0,0,0],[0,0,0],[0,0,0]]
        [[1,1,1],[7,7,7],[7,7,7]]
                            =>  will be 21, but it should be 3
                            
    because when place 1 to place 1, the dp[k] is 0 and days[j][i] = 7; 
    The result is 7, but it should be 0, because there is no flight form other place to place 1
    */
    public int maxVacationDays(int[][] flights, int[][] days) {
        int N =  flights.length; //cities
        int W =  days[0].length; //weeks
        int[] dp =  new int[N];
        Arrays.fill(dp, Integer.MIN_VALUE);  //!!! 
        dp[0] = 0; //!!!
        
        for (int i = 0; i < W; i++) {
            //i is the current week
            int[] temp = new int[N];
            Arrays.fill(temp, Integer.MIN_VALUE);//!!!
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (k == j || flights[k][j] == 1) {
                        //k is other place, j is destination
                        temp[j] = Math.max(temp[j], dp[k] + days[j][i]);
                    }
                }
            }
            dp = temp;
        }
        
        int res = 0;
        for (int num : dp) {
            res = Math.max(res, num);
        }
        
        
        return res;
    }
}
