//n, n

int min = 0;
int max = 0;
public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    for (int i = min; i <= max; i++) {
        res.add(new ArrayList<>());
    }
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<Integer> index = new LinkedList<>();
    index.push(-min);
    queue.push(root);
    while (!queue.isEmpty) {
        TreeNode cur = queue.poll();
        int idx = index.poll();
        res.get(idx).add(cur.val);
        if (cur.left != null) {
            queue.offer(cur.left);
            index.offer(idx - 1);
        }
        if (cur.right != null) {
            queue.offer(cur.right);
            index.offer(idx + 1);
        }
    }
    return res;
}

public void helper(TreeNode root, idx) {
    if (root == null) return;
    min = Math.min(min, idx);
    max = Math.max(max, idx);
    helper(root.left, idx - 1);
    helper(root.right, idx + 1);
}
