package leetcode;

/**
 * @author dylan.ll
 * @date 2020/10/30 10:26
 */
public class MaxSubArray_53_最大子数组和 {
    /**
     * 动态规划
     * f(i) 表示以i结尾的最大子序列和
     * f(i) = max(f(i-1)+nums[i],nums[i])
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < n; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            max = Math.max(max, dp);
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(new MaxSubArray_53().maxSubArray(new int[]{-2,-1}));
        System.out.println(new MaxSubArray_53_最大子数组和().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));


    }
}
