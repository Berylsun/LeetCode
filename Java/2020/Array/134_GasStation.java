//O(n), O(1)
// if total >= 0, it must have a solution.
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length) return -1;
        int total = 0;
        int sum = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (sum < 0) {
                start = i;
                sum = gas[i] - cost[i];
            } else {
                sum += gas[i] - cost[i];
            }
        }

        return total < 0 ? -1 : start;
    }
}