package leetcode;

/**
 * @author dylan.ll
 * @date 2020/6/13 17:02
 */
public class Shuffle {
    public int[] shuffle(int[] nums, int n) {
        int[] res=new int[2*n];
        for(int i=0,j=n,k=0;i<n;i++,j++){
            res[k++]=nums[i];
            res[k++]=nums[j];
        }
        return res;
    }
}
