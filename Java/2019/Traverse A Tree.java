**Recursion**

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
    public List<Integer> preorderTraversal(TreeNode root) {       
        List<Integer> res = new ArrayList<>();
        helper(res,root);
        return res;
    }
    public void helper(List<Integer> num, TreeNode node) {
        if (node == null) {return;}
        num.add(node.val);
        helper(num, node.left);
        helper(num, node.right);
    }
}



class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }
    public void helper(List<Integer> res, TreeNode node) {
        if (node == null) {return;}
        helper(res,node.left);
        res.add(node.val);
        helper(res,node.right);
    }
}



class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res,root);
        return res;
    }
    public void helper(List<Integer> res, TreeNode node) {
        if (node == null) {return;}
        helper(res,node.left);
        helper(res,node.right);
        res.add(node.val);
    }
}

--------------------------------
**Iteration**

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
              if(p != null) {
                  stack.push(p);
                  result.add(p.val);  // Add before going to children
                  p = p.left;
              } else {
                  TreeNode node = stack.pop();
                  p = node.right;  
        }
        return result;
    }
}


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
             if(p != null) {
                  stack.push(p);
                  p = p.left;
             } else {
                  TreeNode node = stack.pop();
                  result.add(node.val);  // Add after all left children
                  p = node.right;   
        }
        return result;
    }
}



class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.add(0,p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }
}


-----------------------------
#BFS

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
    public List<List<Integer>> levelOrder(TreeNode root) {        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {return res;}
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> sub = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                sub.add(queue.poll().val);
            }
            res.add(sub);
        }
        return res;
    }
}
