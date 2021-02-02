class Solution {
    /**
     * O(mn)
     * O(n)
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n + 1];
        int res = 0;

        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < n + 1; j++) {
                if (j < n) {
                    if (matrix[i][j] == '1') {
                        heights[j]++;
                    } else {
                        heights[j] = 0;
                    }
                }

                while (!stack.isEmpty() && heights[j] < heights[stack.peek()]) {
                    int h = heights[stack.pop()];
                    int start = stack.isEmpty() ? -1 : stack.peek();
                    int area = h * (j - start - 1);
                    res = Math.max(res, area);
                }
                stack.push(j);
            }
        }
        return res;
    }
}