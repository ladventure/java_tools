package leetcode;

public class SearchMatrix_74_搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length==0){
            return false;
        }
        int start=0;
        int secondLen = matrix[0].length;
        int end=matrix.length * secondLen -1;

        while (start<end){
            int mid=(start+end) >> 1;
            int secondIndex= getSecondIndex(mid, secondLen);
            int firstIndex= getFirstIndex(mid, secondLen);
            int midValue= matrix[firstIndex][secondIndex];
            if(midValue==target){
                return true;
            }else if(midValue<target){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }

        if(matrix[getFirstIndex(start,secondLen)][getSecondIndex(start,secondLen)]==target){
            return true;
        }
        return false;
    }

    private int getFirstIndex(int mid, int secondLen) {
        return mid/secondLen;
    }

    private int getSecondIndex(int mid, int secondLen) {
        return mid%secondLen;
    }


    public static void main(String[] args) {
        int[][] matix={{1,3,5}};
        System.out.println(new SearchMatrix_74_搜索二维矩阵().searchMatrix(matix,0));
    }
}
