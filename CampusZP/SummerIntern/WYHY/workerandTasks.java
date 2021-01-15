import java.util.*;

public class workerandTasks {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int N = in.nextInt();
        Integer[] W = new Integer[N];
        Integer[] T = new Integer[N];
        for (int i = 0; i < N; i++) {
            W[i] = in.nextInt();
        }
        for (int i = 0; i < N; i++) {
            T[i] = in.nextInt();
        }
        int M = in.nextInt();
        helper(W, T, M);
    }

    private static void helper(Integer[] W, Integer[] T, int M) {
        Arrays.sort(W, (a, b)-> b - a);  //reverseOrder need Integer instead of int
        Arrays.sort(T, (a, b) -> b - a);
        int j = 0;
        int res = 1;
        for (int i = 0; i < T.length; i++) {
            while (j < W.length && W[j] >= T[i]) j++;
            res = res * (j - i) % M;
        }
        System.out.println(res);
    }
}
