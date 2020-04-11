package meituan;

import java.util.HashMap;
import java.util.Scanner;

public class SABC {
//    public static void main(String[] args) {
//        Scanner in  = new Scanner(System.in);
//        int K = in.nextInt();
//        HashMap<Character, char[]> map = new HashMap<>();
//        map.put('S', new char[] {'A', 'B', 'C'});
//        map.put('A', new char[] {'S', 'C', 'B'});
//        map.put('B', new char[] {'S', 'A', 'C'});
//        map.put('C', new char[] {'S', 'B', 'A'});
//        long res = helper(map, K, 'S');
//    }

    public static long helper(HashMap<Character, char[]> map, int k, char start) {
        if (k == 0) {
            if (start == 'S') {
                return 1;
            }
            return 0;
        }
        long res = 0;
        res += helper(map, k - 1, map.get(start)[0]);
        res += helper(map, k - 1, map.get(start)[1]);
        res += helper(map, k - 1, map.get(start)[2]);
        return res;
    }

    private static void solution(int k) {
        long[][] recorder = new long[4][k + 1];
        recorder[0][0] = 1;
        long mod = 1000000007;
        for (int i = 1; i < k + 1; ++ i) {
            for (int j = 0; j < 4; ++ j) {
                for (int m = 0; m < 4; ++ m) {
                    if (m == j) {
                        continue;
                    }
                    recorder[j][i] += recorder[m][i - 1] % mod;
                    recorder[j][i] %= mod;
                }
                recorder[j][i] %= mod;
            }
        }
        System.out.println(recorder[0][k] % mod);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        solution(k);
    }
}

