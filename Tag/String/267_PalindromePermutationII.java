class Solution {
    /**
     * unknown
     * O(n)
     */
    List<String> res = new ArrayList<>();
    public List<String> generatePalindromes(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int odd = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            odd += map.get(s.charAt(i)) % 2 == 1 ? 1 : -1;
        }
        if (odd > 1) return res;

        String mid = "";
        List<Character> list = new ArrayList<>();
        for (char c : map.keySet()) {
            int val = map.get(c);
            if (val % 2 == 1) mid += c;
            for (int i = 0; i < val / 2; i++) {
                list.add(c);
            }
        }
        helper(mid, list, new boolean[list.size()], new StringBuilder());
        return res;
    }

    public void helper(String mid, List<Character> list, boolean[] used, StringBuilder sb) {
        if (sb.length() == list.size()) {
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse(); //!!!!!!!!!!!!
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue; //!!!!delete duplicates
            if (!used[i]) {
                used[i] = true;
                sb.append(list.get(i));
                helper(mid, list, used, sb);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}