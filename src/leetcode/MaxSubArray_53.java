package leetcode;

/**
 * @author dylan.ll
 * @date 2020/10/30 10:26
 */
public class MaxSubArray_53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int dp = nums[0];
        for (int i = 1; i < n; i++) {

            // 计算变迁的sum,tmp 表示带i的子序列和
            int tmp = 0;
            for (int j = i; j >= 0; j--) {
                tmp += nums[j];
                if (tmp > dp) {
                    dp = tmp;
                }
                if (tmp < 0) {
                    break;
                }

            }

        }
        return dp;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1};
        System.out.println(new MaxSubArray_53().maxSubArray(nums));
    }
}
