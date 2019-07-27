//log(m*n), 1
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int begin = 0;
        int end = row * col - 1;
        
        while (begin <= end) {
            int mid = (end - begin) / 2 + begin;
            int midRow = mid / col;
            int midCol = mid % col;
            if (matrix[midRow][midCol] == target) return true;
            if (matrix[midRow][midCol] < target) {
                begin = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        
        return false;
    }
}
