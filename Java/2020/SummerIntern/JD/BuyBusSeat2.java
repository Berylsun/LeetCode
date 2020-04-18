import java.util.Scanner;

/**
 * https://blog.csdn.net/mhywoniu/article/details/105605758
 */
public class BuyBusSeat2 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int[] f = new int[n];
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = in.nextInt();
            t[i] = in.nextInt();
        }
        int res = helper(f, t);
        System.out.println(res);
    }

    //找到最大重叠的区间
    public static int helper(int[]s , int[] t) {
        int ans = 0;
        int n = s.length;
        for (int i=0; i<n; ++i){
            int tmp = 0;
            for (int j=0; j<n; ++j){
                if(j==i) continue;
                if(isIntersect(s[i], t[i], s[j], t[j])){
                    tmp++;
                }
            }
            ans = Math.max(ans, tmp);
        }
        return ans+1;
    }
    public static boolean isIntersect(int l1, int r1, int l2, int r2){
        if(r1<=l2 || r2<=l1){
            return false;
        }else{
            return true;
        }
    }
}
