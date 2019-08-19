//time : O(m * n *nB), space : O(m * nB)
/*
          |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
     AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                       | 0 0 1 |
*/
public int[][] multiply(int[][] A, int[][] B) {
    int m = A.length;
    int n = A[0].length;
    int nB = B[0].length;
    int[][] res = new int[m][nB];
    
    for (int i = 0; i < m; i++) {
        for (int k = 0; k < n; k++) {
            if (A[i][k] != 0) {
                for (int j = 0; j < nB; j++) {
                    if (B[k][j] != 0) res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }
    
    return res;
}
