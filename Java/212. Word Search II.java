class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(res,root, board, i, j);
            }
        }
        return res;
    }
    
 //构建Trie   
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int j = c - 'a';
                if (cur.children[j] == null) {
                    cur.children[j] = new TrieNode();
                }
                cur = cur.children[j];
            }
            cur.word = word;
        }
        return root;
    }
//dfs 遍历    
    public void dfs(List<String> res, TrieNode p, char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        char c = board[i][j];
        if (board[i][j] == '#' || p.children[c - 'a'] == null) return;
        p = p.children[c - 'a'];
        if (p.word != "") {
            res.add(p.word);
            p.word = "";
        }
        board[i][j] = '#';
        dfs(res, p, board, i + 1, j);
        dfs(res, p, board, i - 1, j);
        dfs(res, p, board, i, j + 1);
        dfs(res, p, board, i, j - 1);
        board[i][j] = c;
    }
    
    
    
}

class TrieNode{
    TrieNode[] children;
    String word;
    public TrieNode() {
        children = new TrieNode[26];
        word = "";
    }
}
