import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class canMakeaBoxes {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int T = in.nextInt();
        long[][] boxes = new long[6][2];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 6; j++) {
                boxes[j][0] = in.nextInt();
                boxes[j][1] = in.nextInt();
                if (boxes[j][0] > boxes[j][1]) {
                    long temp = boxes[j][0];
                    boxes[j][0] = boxes[j][1];
                    boxes[j][1] = temp;
                }
            }
            if (helper(boxes)) {
                System.out.println("POSSIBLE");
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    public static boolean helper(long[][] boxes) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            set.add(boxes[i][0]);
            set.add(boxes[i][1]);
            map.put(boxes[i][0] + " " +  boxes[i][1], map.getOrDefault(boxes[i][0] + " " +  boxes[i][1], 0) + 1);
        }
        if (map.size() == 1) return true;
        if (map.size() == 2) {
            int h = 0;
            int w = 0;
            for (String key : map.keySet()) {
                String[] s = key.split(" ");
                if (s[0].equals(s[1])) {
                    if (map.get(key) == 4) {
                        return false;
                    }
                    h = Integer.parseInt(s[0]);
                } else {
                    w = Math.min (Integer.parseInt(s[0]), Integer.parseInt(s[1]));
                }
            }
            if (w == h) {
                return true;
            }
        }
        if (map.size() == 3 && set.size() == 3)  {
            for (String key : map.keySet()) {
                String[] s = key.split(" ");
                if (s[0].equals(s[1])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void print(int[][] boxes) {
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[0].length; j++) {
                System.out.print (boxes[i][j] + " ");

            }
        }
    }
}
