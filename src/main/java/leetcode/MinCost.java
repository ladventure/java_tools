package leetcode;

/**
 * @author dylan.ll
 * @date 2020/6/15 15:40
 */
public class MinCost {


    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] res = new int[m][n+1][target+1];
        int targetCost=10000000;
        //初始化记录表
        //for (int i = 0; i < m; i++) {
        //    for (int j = 1; j <= n; j++) {
        //        for (int k = 1; k <= target; k++) {
        //            res[i][j][k] = 0;
        //        }
        //    }
        //}

        //初始化第一个值
        if (houses[0] != 0) {
            res[0][houses[0]][1] = 0;
        } else {
            for (int i = 0; i < n; i++) {
                res[0][i][0] = cost[0][i];
            }
        }

        //状态转移
        for (int i = 1; i < m; i++) {
            for (int k = 1; k <= target; k++) {
                int minKD1 = 10000000;
                //初始化第一个值
                if (houses[i] != 0) {

                    for (int j = 1; j <=n; j++) {
                        if (houses[i - 1] == j) {
                            minKD1 = Math.min(res[i - 1][j][k], minKD1);
                        } else {
                            minKD1 = Math.min(res[i - 1][j][k - 1], minKD1);
                        }
                    }
                    res[i][houses[i]][k] = minKD1;

                } else {
                    for (int j = 0; j < n; j++) {
                        minKD1 = 10000000;
                        for (int  l= 0; l < n; l++) {
                            if (houses[i - 1] == j) {
                                minKD1 = Math.min(res[i - 1][j][k]+cost[i][j], minKD1);
                            } else {
                                minKD1 = Math.min(res[i - 1][j][k - 1]+cost[i][j], minKD1);
                            }
                        }
                        res[i][j][k] = minKD1;

                    }


                }

                if(k==target-1){
                    targetCost=Math.min(targetCost,res[i][houses[i]][k]);
                }
            }
        }

        return targetCost;
    }

    public static void main(String[] args) {
       int[] houses={0,0,0,0,0};
        int[][] cost = {{1,10},{10,1},{10,1},{1,10},{5,1}};
        int m = 5, n = 2, target = 3;
        System.out.println(new MinCost().minCost(houses,cost,m,n,target));
    }
}
