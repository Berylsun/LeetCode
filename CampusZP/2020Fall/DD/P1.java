package DD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =  in.nextInt();
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            for (int j = 0; j <= 9; j++) {
                if (j == i) continue;
                sb.append(j);
                for (int k = 0; k <= 9; k++) {
                    if (k == sb.toString().charAt(0) - '0' || k == sb.toString().charAt(1) - '0') continue;
                    sb.append(k);
                    String abcstr = sb.toString();
                    int abc = Integer.parseInt(abcstr);
                    String acc = "" + abcstr.charAt(0) + abcstr.charAt(2) + abcstr.charAt(2);
                    if (n == Integer.parseInt(acc) + abc) {
                        res.add(abc + " " + acc);
                    }
                    sb = new StringBuilder(sb.toString().substring(0, 2));
                }
                sb = new StringBuilder(sb.toString().substring(0, 1));
            }
        }
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
