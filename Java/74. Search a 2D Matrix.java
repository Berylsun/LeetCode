class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = m * n - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            int val = matrix[mid / n][mid % n];
            if (val == target) return true;
            else if (val < target) {
                i = mid + 1;
            }else {
                j = mid - 1;
            }
        }
        return false;
    }
}
