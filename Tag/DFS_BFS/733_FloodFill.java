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
}