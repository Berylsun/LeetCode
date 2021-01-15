/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode node  = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            add(node, preorder[i]);
        }
        return node;
    }
    public void add(TreeNode node, int i) {
        if (i < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(i);
            } else {
                add(node.left, i);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(i);
            } else {
                add(node.right, i);
            }
        }
        return;
    }


    /**
     * O(n)
     */
    int i = 0;
    public TreeNode bstFromPreorder(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound) return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }
}


