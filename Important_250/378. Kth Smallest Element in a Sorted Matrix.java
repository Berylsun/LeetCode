//nlogn, n
class Solution {
    
    class Tuple {
        public int x;
        public int y;
        public int val;
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int n = matrix.length;
        
        for (int i = 0; i < n; i++) {
            pq.offer(new Tuple(i, 0, matrix[i][0]));
        }
        
        int count = 0;
        while (!pq.isEmpty()) {
            Tuple cur = pq.poll();
            count++;
            if (count == k) {
                return cur.val;
            }
            
            if (cur.y == n - 1) continue;
            pq.offer(new Tuple(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
        }
        
        return 0;
    }
}

// time : O(n * log(max - min)) space : O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            int num = count(matrix, mid);
            if (num < k) {
                left = mid;
            }else {
                right = mid;
            }
        }
        
        if (count(matrix, right) <= k - 1) return right;
        return left;
    }
    
    public int count(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        int res = 0;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] < target) {
                res += j + 1;
                i++;
            }else {
                j--;
            }
        }
        
        return res;
    }
}
