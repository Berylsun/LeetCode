class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length==0){
            return new ArrayList<>();
        }
        int M=matrix.length,N=matrix[0].length;
        List<Integer> res= new ArrayList<>();
        int b=0,a=0,m=0;
        while(res.size()<matrix.length*matrix[0].length){
            //moving right                  
            for(int i=b;i<N;i++){
                res.add(matrix[m][i]);
            }
            N--;
            m++;
            //moving down       
            for(int i = m;i<M;i++){
                res.add(matrix[i][N]);
            }
            M--;
            if (res.size()==matrix.length*matrix[0].length){      //must add this condition before movng left
                return res;                               //because a++ is added after the moving left condition
            } 
            //moving left
            for(int i =N-1;i>=a;i--){
                res.add(matrix[M][i]);
            }
            a++;
            //moving up 
            for(int i=M-1;i>=m;i--){
                res.add(matrix[i][a-1]);
            }
            b=a;
        }
        return res;
    }
}
