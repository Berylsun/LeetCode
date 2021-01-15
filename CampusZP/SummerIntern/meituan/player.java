package meituan;

import java.util.*;

public class player {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = in.nextInt();
        }
        helper(A, B);
    }

    public static void helper(int[] players, int[] res) {
        int[] projection = new int[players.length + 1];
        for (int i = 0; i < players.length; ++ i) {
            projection[players[i]] = i;
        }
        int[] resProjection = new int[players.length];
        for (int i = 0; i < res.length; ++ i) {
            resProjection[i] = projection[res[i]];
        }
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < res.length; ++ i) {
            while (! stack.empty() && resProjection[stack.peek()] > resProjection[i]) {
                stack.pop();
                count ++;
            }
            stack.push(i);
        }
        System.out.println(count);
    }
}
