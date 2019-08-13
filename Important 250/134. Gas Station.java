//n, 1
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) return -1;
        
        int total = 0;
        int sum = 0;
        int res = 0;
        
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                res = i + 1;
            }
        }
        
        return total >= 0 ? res : -1;
    }
}
