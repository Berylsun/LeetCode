//n, n
BFS!!!
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 1;
        int curNum = 1;
        int nextNum = 0;
        HashSet<String> unvisited = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            curNum--;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char c = 'a'; c <= 'z'; c++) {
                    sb.setCharAt(i, c);
                    String newWord = sb.toString();
                    if (unvisited.contains(newWord)) {
                        if (endWord.equals(newWord)) {
                            level++;
                            return level;
                        }
                        nextNum++;
                        unvisited.remove(newWord);
                        queue.offer(newWord);
                    }
                }
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return 0;
    }
}
