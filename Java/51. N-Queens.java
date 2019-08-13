// n ^ n, n
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) return res;
        helper(res, new int[n], 0);
        return res;
    }
    
    // queens[]: 每行queen所在的列； pos:行；
    public void helper(List<List<String>> res, int[] queens, int pos) {
        if (pos == queens.length) {
            addSolution(res, queens);
            return;
        }
        
        for (int i = 0; i < queens.length; i++) {
            queens[pos] = i;
            if (isValid(queens, pos)) {
                helper(res, queens, pos + 1);
            }
        }
    }
    
    
    public boolean isValid(int[] queens, int pos) {
        for (int i = 0; i < pos; i++) {
            if (queens[i] == queens[pos]) { //判断是否在同一列上
                return false;
            }else if (Math.abs(queens[i] - queens[pos]) == Math.abs(i - pos)) { //判断是否在同一对角线
                return false;
            }
        }
        return true;
    }
    
    public void addSolution(List<List<String>> res, int[] queens) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                if (queens[i] == j) {
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        
        res.add(new ArrayList<>(list));
    }
}
