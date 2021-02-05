class Solution {
    int res;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        for (int i = 0; i < price.size(); i++) {
            res += price.get(i) * needs.get(i);
        }
        helper(price, special, needs, 0, res);
        return res;
    }

    public void helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int idx, int money) {
        if (idx >= special.size()) return;
        List<Integer> p = special.get(idx);
        boolean can = true;
        List<Integer> newneeds = new ArrayList<>();
        int tmp = 0;
        for (int i = 0; i < p.size() - 1; i++) {
            if (needs.get(i) < p.get(i)) {
                can = false;
                break;
            }
            newneeds.add(needs.get(i) - p.get(i));
            tmp += price.get(i) * p.get(i);
        }
        if (can) {
            int newmoney = money - tmp + p.get(p.size() - 1);
            res = Math.min(res, newmoney);
            helper(price, special, newneeds, idx, newmoney);
        }
        helper(price, special, needs, idx + 1, money);
    }
}