//m*n, n
DP!!!!!
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (matrix == null || m == 0) return 0;
        int n = matrix[0].length;
        int res = 0;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                }else height[j] = 0;
            }
            
            int curLeft = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(curLeft, left[j]);
                }else {
                    curLeft = j + 1;
                    left[j] = 0;
                }
            }
            
            int curRight = n;
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(curRight, right[j]);
                }else {
                    curRight = j;
                    right[j] = n;
                }
            }
            
            for (int j = 0; j < n; j++) {
                int area = height[j] * (right[j] - left[j]);
                res = Math.max(res, area);
            }
        }
        return res;
    }
}

//similar 84
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int m = matrix.length;
        if (matrix == null || m == 0) return res;
        int n = matrix[0].length;
        int[] height = new int[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                }else {
                    height[j] = 0;
                }
            }
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j <= n; j++) {
                int h = j == n ? 0 : height[j];
                while (!stack.isEmpty() && h < height[stack.peek()]) {
                    int hi = height[stack.pop()];
                    int start = stack.isEmpty() ? -1 : stack.peek();
                    int area = hi * (j - start - 1);
                    res = Math.max(res, area);
                }
                stack.push(j);
            }
        }
        return res;
    }
}
