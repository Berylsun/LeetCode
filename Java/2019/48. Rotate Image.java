class Solution {
    public void rotate(int[][] matrix) {
        /* e.g.
            [
             [1,2,3],
             [4,5,6],
             [7,8,9]
                    ]
        */
        
        //以159为轴转换
        for (int i = 0; i < matrix.length; i++) {
            //j要从i开始，否则又会变回去
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //以456为轴转换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = temp;
            }
        }
    }
}
