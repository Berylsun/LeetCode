class Solution {
    /**
     * O(n)
     * O(n)
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color == newColor) return image;  //!!!!
        helper(image, sr, sc, newColor, color);
        return image;
    }

    public void helper(int[][] image, int i, int j, int newColor, int color) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != color) return;
        image[i][j] = newColor;
        helper(image, i + 1, j, newColor, color);
        helper(image, i - 1, j, newColor, color);
        helper(image, i, j + 1, newColor, color);
        helper(image, i, j - 1, newColor, color);
    }

    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        image[sr][sc] = newColor;
        queue.offer(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int j = 0; j < 4; j++) {
                int x = cur[0] + dir[j][0];
                int y = cur[1] + dir[j][1];
                if (x < 0 || x >= m || y < 0 || y >= n || image[x][y] != oldColor) {
                    continue;
                }
                image[x][y] = newColor;
                queue.offer(new int[]{x, y});
            }
        }
        return image;
    }
}