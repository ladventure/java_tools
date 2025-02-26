package leetcode;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/description/?envType=study-plan-v2&envId=top-100-liked
 * 从右上角开始找，比target 大，往左找，比target 小，往下找
 *
* */
public class SearchMatrix_240_搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int i=0,j=matrix[0].length-1;
        while (i<matrix.length && j>=0){
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]>target){
                --j;
            }else {
                ++i;
            }
        }
        return false;
    }
}
