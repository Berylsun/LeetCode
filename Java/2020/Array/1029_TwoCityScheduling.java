class Solution {
    /**
     * O(nlogn)
     * O(n)
     * @param costs
     * @return
     */
    public int twoCitySchedCost(int[][] costs) {
        int cn = 0;
        int[] refund = new int[costs.length];
        int index = 0;
        for (int[] cost : costs) {
            refund[index++] = cost[1] - cost[0];
            cn += cost[0];
        }
        Arrays.sort(refund);
        for (int i = 0; i < costs.length / 2; i++) {
            cn += refund[i];
        }
        return cn;
    }
}