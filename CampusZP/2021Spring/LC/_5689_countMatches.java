class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        if (items == null || items.size() == 0) return res;
        int idx = 0;
        if (ruleKey.equals("color")) {
            idx = 1;
        } else if (ruleKey.equals("name")) {
            idx = 2;
        }

        for (List<String> item : items) {
            if (item.get(idx).equals(ruleValue)) {
                res++;
            }
        }
        return res;
    }
}