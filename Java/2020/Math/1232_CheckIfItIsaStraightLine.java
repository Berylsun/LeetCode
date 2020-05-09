class Solution {
    /**
     * O(n)
     * O(1)
     * @param coordinates
     * @return
     */
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 3) return true;
        int[] p1 = coordinates[0];
        int[] p2 = coordinates[1];
        double a = 0;
        if (p1[0] != p2[0]) {
            a = (double)(p1[1] - p2[1]) / (p1[0] - p2[0]);
        }
        double b = p1[1] - a * p1[0];

        for (int i = 2; i < coordinates.length; i++) {
            if (a * coordinates[i][0] + b != coordinates[i][1]) {
                return false;
            }
        }
        return true;
    }
}