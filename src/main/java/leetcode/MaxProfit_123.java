package leetcode;

/**
 * @author dylan.ll
 * @date 2020/10/29 15:53
 */
public class MaxProfit_123 {

    //public int maxProfit(int[] prices,int k) {
    //    int n = prices.length;
    //    if(n==0 || k==0){
    //        return 0;
    //    }
    //    int status=2*k+1;
    //
    //    int[][] dp = new int[n][status];
    //    int max = 0;
    //
    //    //初始化，第一天的时候，所有状态的dp 值.如果买入，则dp 为负的第一天价值，如果卖出，则dp=0
    //    for (int i = 1; i <status ; i++) {
    //        dp[0][i]= i%2==0 ? 0:-prices[0];
    //    }
    //
    //    for (int i = 1; i < n; i++) {
    //        for (int j = 1; j <status ; j++) {
    //            dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]+ (j%2==0 ? prices[i]:-prices[i]) );
    //        }
    //
    //    }
    //    for (int i = 0; i <status ; i++) {
    //        max=Math.max(max,dp[n-1][i]) ;
    //    }
    //
    //    return max;
    //}


    public  int ComleteMaxProfit(int[] prices){
        int max=0;
        for(int i=1;i<prices.length;i++){

            int dif=prices[i]-prices[i-1];

            if(dif>0){
                max+=dif;
            }
        }

        return max;
    }
    //优化内存溢出
    public int maxProfit(int k,int[] prices) {
        int n = prices.length;
        if(n==0 || k==0){
            return 0;
        }

        if(k>n/2){
           return ComleteMaxProfit(prices);
        }
        int status=2*k+1;

        int[] dp=new int[status];
        //int[][] dp = new int[n][status];
        int max = 0;

        //初始化，第一天的时候，所有状态的dp 值.如果买入，则dp 为负的第一天价值，如果卖出，则dp=0
        for (int i = 1; i <status ; i++) {
            dp[i]= i%2==0 ? 0:-prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = status-1; j >0 ; j--) {
                dp[j]=Math.max(dp[j],dp[j-1]+ (j%2==0 ? prices[i]:-prices[i]));
            }

        }
        for (int i = 0; i <status ; i++) {
            max=Math.max(max,dp[i]) ;
        }

        return max;
    }

    public static void main(String[] args) {
        //int[] prises={3,3,5,0,0,3,1,4};
        //System.out.println(new MaxProfit_123().maxProfit(prises,2));

        int[] prises={3,2,6,5,0,3};
        System.out.println(new MaxProfit_123().maxProfit(2,prises));


    }
}
