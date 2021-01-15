package BK;
// kruskal
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P4 {

    public static class Node {
        int u;
        int v;
        int w;
        Node(int u, int v, int a, int b) {
            this.u = u;
            this.v = v;
            long sumab = 1;
            for (int i = b + 1; i <= a; i++) {
                sumab = sumab * i % 1000000007;
            }

            long sumb = 1;
            for (int i = 1; i <= b; i++) {
                sumb = sumb * i % 1000000007;
            }

            this.w = (int) (sumab / sumb);
        }
    }

    public static long res = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Node> list = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            Node node = new Node(u, v, a, b);
            list.add(node);
            sum += node.w;
        }
        list.sort((a, b) -> b.w - a.w);
        helper(list, n);
        System.out.println(res);
    }

    public static void helper(List<Node> list, int n) {
        int[] nums = new int[n + 1];
        int num = 0;
        for (int L = 0; L < list.size(); L++) {
            long sum = 0;
            for (int i = 0; i <= n; i++) nums[i] = i;
            for (int R = L; R < list.size(); R++) {
                int u = find(nums, list.get(R).u);
                int v = find(nums,list.get(R).v);
                if (u != v) {
                    nums[u] = v;
                    num++;
                    sum = (sum + list.get(R).w) % 1000000007;
                    if (num == n - 1) {
                        res = Math.max(res, sum);
                    }
                }
            }
        }
    }

    public static int find(int[] nums, int x) {
        if (nums[x] != x) {
            nums[x] = find(nums, nums[x]);
        }
        return nums[x];
    }
}
