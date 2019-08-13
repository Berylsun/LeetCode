// time : (nlogn) space : O(n)
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>(matrix.length, (a, b) -> (a.val - b.val));
        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple tuple = pq.poll();
            if (tuple.x == matrix.length - 1) continue;
            pq.offer(new Tuple(tuple.x + 1, tuple.y, matrix[tuple.x + 1][tuple.y]));
        }
        return pq.poll().val;
    }

    class Tuple {
        int x, y, val;
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

// time : O(n * log(max - min)) space : O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix[0].length == 0) return 0;
        int n = matrix.length;
        int i = matrix[0][0];
        int j = matrix[n - 1][n - 1];
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            int num = count(matrix, mid);
            if (num < k) {
                i = mid + 1;
            }else {
                j = mid - 1;
            }
        }
        return i - 1;
    }
    
    public int count(int[][] matrix, int val) {
        int res = 0;
        int n = matrix.length;
        int row = n - 1;
        int col = 0;
        while (col < n && row >= 0) {
            if (matrix[row][col] < val) {
                res += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return res;
    }
}
