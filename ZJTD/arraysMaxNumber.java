import java.util.*;

public class Solution {
    /**
     * O(nlogn)
     * O(n)
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            int n = str.length();
            String[] strs = str.substring(1, n - 1).split(",");
            Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strs.length; i++) {
                sb.append(strs[i]);
            }
            System.out.println(sb.toString());
        }
    }
}