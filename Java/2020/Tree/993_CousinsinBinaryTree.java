/**
 * O(n)
 * O(n)
 */
class Solution {
    int xdepth = -1;
    int ydepth = -1;
    TreeNode xparent = null;
    TreeNode yparent = null;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, x, y, 0, null);
        return xdepth == ydepth && xparent != yparent ? true : false;
    }

    public void helper(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if (root == null) return;
        if (root.val == x) {
            xparent = parent;
            xdepth = depth;
        } else if (root.val == y) {
            yparent = parent;
            ydepth = depth;
        }
        helper(root.left, x, y, depth + 1, root);
        helper(root.right, x, y, depth + 1, root);
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        int xdepth = -1;
        int ydepth = -1;
        int xparent = -1;
        int yparent = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (node.left.val == x) {
                        xdepth = level;
                        xparent = node.val;
                    } else if (node.left.val == y) {
                        ydepth = level;
                        yparent = node.val;
                    }
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    if (node.right.val == x) {
                        xdepth = level;
                        xparent = node.val;
                    } else if (node.right.val == y) {
                        ydepth = level;
                        yparent = node.val;
                    }
                    queue.offer(node.right);
                }
            }
        }
        return xdepth == ydepth && xparent != yparent;
    }
}