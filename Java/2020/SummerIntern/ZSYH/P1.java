import java.util.HashMap;
import java.util.Scanner;

/**
 * 招商银行
 * 判断是否为镜像对称字符串
 */
public class P1 {
    public static void main(String[] args) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('2', '5');
        map.put('3', '8');
        map.put('4', '7');
        map.put('5', '2');
        map.put('6', '9');
        map.put('7', '4');
        map.put('8', '3');
        map.put('9', '6');
        Scanner in  = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        for (int i = 0; i < T; i++) {
            String s = in.nextLine();
            if (isMirror(s, map)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    public static boolean isMirror(String s, HashMap<Character, Character> map) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) == map.get(s.charAt(r))) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
