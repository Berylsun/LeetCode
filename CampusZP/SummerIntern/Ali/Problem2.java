import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for (int i=0;i<t;i++){
            int n=scanner.nextInt();
            int max_step=scanner.nextInt();
            int[][] value=new int[n+1][n+1];
            for (int j=1;j<=n;j++){
                for (int k=1;k<=n;k++){
                    value[j][k]=scanner.nextInt();
                }
            }
            int[][] dp=new int[n+1][n+1];
            System.out.println(calcMaxWay(1,1,max_step,dp,value));
        }
    }
    private static int calcMaxWay(int x,int y,int max_step,int[][] dp,int[][] value){
        if (dp[x][y]>0)
            return dp[x][y];
        int max_sum=0;

        for (int step=1;step<=max_step;step++){

            if(y-step>0 && value[x][y-step]>value[x][y]) max_sum=Math.max(max_sum,calcMaxWay(x,y-step,max_step,dp,value));
            if(y+step<value[1].length && value[x][y+step]>value[x][y]) max_sum=Math.max(max_sum,calcMaxWay(x,y+step,max_step,dp,value));
            if(x-step>0 &&value[x-step][y]>value[x][y]) max_sum=Math.max(max_sum,calcMaxWay(x-step,y,max_step,dp,value));
            if(x+step<value[1].length && value[x+step][y] > value[x][y])max_sum=Math.max(max_sum,calcMaxWay(x+step,y,max_step,dp,value));
        }
        dp[x][y]=value[x][y]+max_sum;
        return dp[x][y];
    }
}