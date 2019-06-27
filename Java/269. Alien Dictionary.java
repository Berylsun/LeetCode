//v + E， n -> 26 -> 1
public static String alienOrder(String[] words) {
    if (words == null || words.length == 0) return "";   
    StringBuilder res = new StringBuilder();
    int[] degree = new int[26];
    int count = 0;
    for (String s : words) {
        for (char c : s.roCharArray()) {
            if (degree[c - 'a'] == 0) {
                count++;
                degree[c - 'a']++;
            }
        }
    }
    HashMap<Character, Set<Character>> map = new HashMap<>();
    for (int i = 0; i < words.length - 1; i++) {
        String[] cur = words[i].toCharArray();
        String[] next = words[i + 1].toCharArray();
        int len = Math.min(cur.length, next.length);
        for (int j = 0; j <len; j++) {
            if (cur[j] != next[j]) {
                if (!map.containsKey(cur[j])) {
                    map.put(cur[j], new HashSet<>());
                }
                if (map.get(cur[j]).add(next[j])) {
                    degree[next[j] - 'a']++;
                }
                break;
            }
        }
    }
    
    Queue<Character> queue = new LinkedList<>();
    for (int i = 0; i < 26; i++) {
        if (degree[i] == 1) {
            queue.offer((char)(i + 'a'));
        }
    }
    
    while (!queue.isEmpty()) {
        char c = queue.poll();
        res.append(c);
        if (map.containsKey(c)) {
            for(char ch : map.get(c)) {
                if (--degree[ch - 'a'] == 1) {
                    queue.offer(ch);
                }
            }
        }
    }
    
    if (res.length() != count) return "";
    return res.toString();
}
