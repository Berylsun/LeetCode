/*
time : O(V + E) * wordList(max(length))  不确定
       O(n ^ 2)
space : O(n)
*/

class Solution {
    //BFS + DFS
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList.size() <= 0) return res;
        
        int curNum = 1;
        int nextNum = 0;
        boolean found = false;
        
        Queue<String> queue = new LinkedList<>();
        HashSet<String> unvisited = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<>();
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        queue.offer(beginWord);
        
        while (!queue.isEmpty()) {
            String str = queue.poll();
            curNum--;
            for (int i = 0; i < str.length(); i++) {
                char[] strs = str.toCharArray();
                for (char c = 'a' ; c <= 'z'; c++) {
                    strs[i] = c;
                    String strsb = new String(strs);
                    if (unvisited.contains(strsb)) {
                        if (visited.add(strsb)) {
                            nextNum++;
                            queue.offer(strsb);
                        }
                        if (map.containsKey(strsb)) {
                            map.get(strsb).add(str);
                        }else {
                            List<String> list = new ArrayList<>();
                            list.add(str);
                            map.put(strsb, list);
                        }
                        
                        if (endWord.equals(strsb)) {
                            found = true;
                        }
                    }
                }
            }
            if (curNum == 0) {
                if (found) break;
                curNum = nextNum;
                nextNum = 0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }
        
        dfs(res, new ArrayList<>(), beginWord, endWord, map);
        return res;
    }
    
    public void dfs(List<List<String>> res, List<String> list, String start, String word, HashMap<String, List<String>> map) {        
        if (word.equals(start)) {
            list.add(0, start);
            res.add(new ArrayList<>(list));
            // list.remove(list.size - 1)
            list.remove(0);
            return;
        }
        list.add(0, word);
        if (map.get(word) != null) {
            for (String s : map.get(word)) {
                dfs(res, list, start, s, map);
            }
        }
        list.remove(0);
    }
}
