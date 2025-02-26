package leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @author dylan.ll
 * @date 2020/7/17 21:03
 */
public class Print {

    int[] result=new int[1000000];
    int count=0;
    public int[] clockwisePrint(int[][] mat, int n, int m) {

        if(n==0 && m==0){
            return null;
        }
        if(n==1){
            for(int i=0;i<m;i++){
                result[count++]=mat[0][i];

            }
        }
        if(m==1){
            for(int i=0;i<n;i++){
                result[count++]=mat[i][0];
            }
        }
        clockwisePrint(mat,  0, 0, n,  m);

        return result;
        // write code here
    }

    public void clockwisePrint(int[][] mat, int start_n,int start_m,int n, int m) {

        for(int i=start_m;i<m;i++){
            result[count++]=mat[start_n][i];

        }
        for(int i=start_n+1;i<n;i++){
            result[count++]=mat[i][m-1];

        }

        for(int i=m-2;i>=start_m;i--){
            result[count++]=mat[n-1][i];
            System.out.println(mat[n-1][i]);
        }
        for(int i=n-2;i>start_n;i++){
            result[count++]=mat[i][start_m];
            System.out.println(mat[i][start_m]);
        }
        if(start_n==n-2){
            for(int i=start_m+1;i<m-1;i++){
                result[count++]=mat[start_n+1][i];
            }
            return;
        }
        if(start_m==m-2){
            for(int i=start_n+1;i<n-1;i++){
                result[count++]=mat[i][start_m+1];
            }
            return;
        }
        clockwisePrint(mat, start_n+1, start_m+1, n-1, m-1);
        // write code here
    }

    public static void main(String[] args) {

        int[][] ab={{4,46,89},{28,66,99},{26,21,71}};
        System.out.println(JSON.toJSONString(new Print().clockwisePrint(ab,3,3)));
    }
}
