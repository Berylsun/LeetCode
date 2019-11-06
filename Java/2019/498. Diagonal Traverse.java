class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length==0){
            return (new int[0]);
        }
        int M=matrix.length;
        int N= matrix[0].length;
        int m=0,n=0;
        int[] res= new int[M*N];
        for(int i =0;i<res.length;i++){
            res[i]=matrix[m][n];
            if ((m+n)%2==0){          //moving up
                if (n==N-1){m++;}
                else if (m==0){n++;}
                else{
                    m--;
                    n++;
                }
            }else{                    //moving down
                if (m==M-1){n++;}
                else if (n==0){m++;}
                else{
                    n--;
                    m++;
                }        
            }
        }
        return res;
    }
}
