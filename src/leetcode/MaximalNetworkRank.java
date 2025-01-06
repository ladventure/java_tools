package leetcode;

/**
 * @author dylan.ll
 * @date 2020/10/15 17:52
 */
public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {

        int[] maxpoint=new int[n];
        int[][] maxRoads=new int[n][n];
        int[][] newRoads=new int[n][n];
        //init
        for(int i=0;i<n;i++){
            for (int j = 0; j <n ; j++) {
                maxRoads[i][j]=0;
            }

        }

        //store road
        for(int i=0;i<roads.length;i++){
            newRoads[roads[i][0]][roads[i][1]]=1;
        }

        //cal max point
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(newRoads[i][j]==1){
                    maxpoint[i]++;
                    maxpoint[j]++;
                }
            }
        }

        int max=0;
        for (int i = 0; i <n ; i++) {
            for (int j = i+1; j <n ; j++) {
                if(i==j){
                    continue;
                }
                int tmp=maxpoint[i]+maxpoint[j]-newRoads[i][j]-newRoads[j][i];
                if(tmp>max){
                    max=tmp;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
      int  n = 8;
      int[][] roads = {{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}};
      //  int[][] roads = {{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}};

        //int  n = 2;
        //int[][] roads = {{1,0}};
      System.out.println(new MaximalNetworkRank().maximalNetworkRank(n,roads));
    }
}
