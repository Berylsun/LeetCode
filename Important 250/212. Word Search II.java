//time : O(m * n * TrieNode)
//space : TrieNode
class Solution {
    //dfs TrieNode 
    class TrieNode {
        TrieNode[] next;
        String word;
        public TrieNode() {
            next = new TrieNode[26];
            word = "";
        }
    }
    
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        for (String word : words) {
            buildTrie(word, root);
        }
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(res, board, i, j, root);
            }
        }
        
        return res;
    }
    
    public void dfs(List<String> res, char[][]board, int i, int j, TrieNode node) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char c = board[i][j];
        if (c == '#' || node.next[c - 'a'] == null) return;
        board[i][j] = '#';
        node = node.next[c - 'a'];
        if (node.word != "") {
            res.add(node.word);
            node.word = "";
        }
        dfs(res, board, i + 1, j, node);
        dfs(res, board, i - 1, j, node);
        dfs(res, board, i, j + 1, node);
        dfs(res, board, i, j - 1, node);
        board[i][j] = c;
    }
    
    public void buildTrie (String word, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.next[index] == null) {
                node.next[index] = new TrieNode();
            }
            node = node.next[index];
        }
        node.word = word;
    }
}
