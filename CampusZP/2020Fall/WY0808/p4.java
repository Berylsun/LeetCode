package WY;
// slim tree 连通图最小边差
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p4 {
    public static class Node {
        int x;
        int y;
        int w;
        Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int w = in.nextInt();
            Node node = new Node(x, y, w);
            list.add(node);

        }
        int res = helper(list, m, n);
        System.out.println(res);
    }

    public static int helper(List<Node> list, int m, int n) {
        int res = Integer.MAX_VALUE;
        list.sort((a, b) -> a.w - b.w);
        int[] nums = new int[n + 1];
        for (int L = 0; L < m; L++) {
            int sum = 0;
            for (int i = 1; i <= n; i++) nums[i] = i;
            for (int R = L; R < m; R++) {
                int u = find(list.get(R).x, nums);
                int v = find(list.get(R).y, nums);
                if (u != v) {
                    nums[u] = v;
                    sum++;
                    if (sum == n - 1) {
                        res = Math.min(res, list.get(R).w - list.get(L).w);
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static int find(int n, int[] nums) {
        if (nums[n] != n) {
            nums[n] = find(nums[n], nums);
        }
        return nums[n];
    }

}
