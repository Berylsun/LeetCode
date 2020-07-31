package KDXF0731;
//矩形是否相交: 默认正放……

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] r1 = new int[4];
        int[] r2 = new int[4];
        r1[0] = in.nextInt();
        r1[1] = in.nextInt();
        r1[2] = in.nextInt();
        r1[3] = in.nextInt();
        r2[0] = in.nextInt();
        r2[1] = in.nextInt();
        r2[2] = in.nextInt();
        r2[3] = in.nextInt();
        if (isRectangleOverlap(r1, r2)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] || rec1[1] >= rec2[3] || rec1[0] >= rec2[2] || rec1[3] <= rec2[1]);
    }
}
