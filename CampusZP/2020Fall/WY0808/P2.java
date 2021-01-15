package WY;
// 字典排序
import java.util.*;

public class P2 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Deque<Integer> deque = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int temp = in.nextInt();
            deque.addLast(temp);
            set.add(temp);
        }
        int[] res = helper(deque, set, n);
        for (int i = 0; i < res.length; i++) {
            if (i == res.length - 1) {
                System.out.print(res[i]);
            } else {
                System.out.print(res[i] + " ");
            }
        }
    }

    public static int[] helper(Deque<Integer> deque, HashSet<Integer> set, int n) {
        int[] res = new int[n];
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) continue;
            if (deque.isEmpty()) {
                res[idx++] = i;
                continue;
            }
            int first = deque.peekFirst();
            if (i < first) {
                deque.addFirst(i);
            } else {
                while (i > first) {
                    res[idx++] = deque.pollFirst();
                    if (!deque.isEmpty()) {
                        first = deque.peekFirst();
                    } else {
                        break;
                    }
                }
                i--;
            }
        }
        while (!deque.isEmpty()) {
            res[idx++] = deque.pollFirst();
        }
        return res;
    }
}
