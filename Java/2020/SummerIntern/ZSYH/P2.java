import java.util.Scanner;

/**
 * 招商银行
 * 先输入行数row，再输入row行“数字+目标”。问，如果在数字之间可以添上加减号，那么使得数字运算后等于目标的添法有几种？
 */
public class P2 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        for (int i = 0; i < T; i++) {
            String s = in.nextLine();
            String[] strs = s.split(" +");
            String num = strs[0];
            int k = Integer.parseInt(strs[1]);
            int res = findSolution(num, k, 0);
            System.out.println(res);
        }
    }

    public static int findSolution(String str, int k, int start) {
        if (start == str.length()) {
            if (k == 0) {
                return 1;
            }
            return 0;
        }
        int num;
        int res = 0;
        for(int i = start; i < str.length(); i++){
            num = Integer.parseInt(str.substring(start, i + 1));
            res += findSolution(str, k - num , i + 1);
            if (start != 0) {
                res += findSolution(str, k + num, i + 1) ;
            }
        }
        return res;
    }
}
