package bilibili;

import java.util.Arrays;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12}};
        int[] res = SpiralMatrix(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] SpiralMatrix (int[][] matrix) {
        // write code here
        int m = matrix.length;
        int n = matrix[0].length;
        int cols = 0;
        int rows = 0;
        int cole = n - 1;
        int rowe = m - 1;
        int[] res = new int[m * n];
        int idx = 0;
        while (idx < m * n) {
            for (int i = cols; i <= cole; i++) {
                res[idx++] = matrix[rows][i];
            }
            rows++;

            for (int i = rows; i <= rowe; i++) {
                res[idx++] = matrix[i][cole];
            }
            cole--;


            if (rows <= rowe) {
                for (int i = cole; i >= cols; i--) {
                    res[idx++] = matrix[rowe][i];
                }
                rowe--;
            }


            if (cols <= cole) {
                for (int i = rowe; i >= rows; i--) {
                    res[idx++] = matrix[i][cols];
                }
                cols++;
            }
        }
        return res;
    }
}
