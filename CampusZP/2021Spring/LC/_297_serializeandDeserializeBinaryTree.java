/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("null ");
                    continue;
                }
                sb.append(node.val);
                sb.append(" ");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] strs = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (i < strs.length) {
            TreeNode cur = queue.poll();
            if (!strs[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(cur.left);
            }
            i++;
            if (!strs[i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(cur.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));