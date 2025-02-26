package leetcode;

/**
 * @author dylan.ll
 * @date 2021/11/6 18:28
 */
public class CountMaxOrSubsets {
    public static void main(String[] args) {
        int[] nums={3,1};
      System.out.println(  new CountMaxOrSubsets().countMaxOrSubsets(nums));
    }
    public int countMaxOrSubsets(int[] nums) {
        int max=nums[0];
        int k=1;
        for (int i = 1; i < nums.length; i++) {
            int step=nums[i]|max;
            if(step==max){
                k++;
            }else {
                max=step;
            }
        }
        return (int)Math.pow(2,k)-1;
    }

}
