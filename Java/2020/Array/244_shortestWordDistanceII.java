//space: O(n)
class WordDistance {
    HashMap<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                map.put(words[i], list);
                list.add(i);
            }
        }
    }

    // O(l1.size() + l2.size())
    public int shortest(String word1, String word2) {
        int res = Integer.MAX_VALUE;
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int i = 0;
        int j = 0;
        while (i < l1.size() && j < l2.size()) {
            res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
            if (l1.get(i) > l2.get(j)) {
                j++;
            } else {
                i++;
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */

// you can also set a global string[], but you will need O(n) time which is longer than O(l1.size() + l2.size())