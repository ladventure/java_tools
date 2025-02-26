package leetcode;

import java.util.HashMap;

public class SubarraySum_560_和为K的子数组 {
    /**
     * 前缀和 + 哈希表优化
     * 求解所有的前缀和，使用 map 缓存前缀和出现的次数，然后遍历前缀和计算前缀和的差值是否等于k
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);    // 缓存前缀和出现的次数
        }
        return count;
    }
    /**
     * 动态规划解
     * 计算 f[i,j] = f[i,j-1] + nums[j] i<j
     * 超出时间限制
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] fi=new int[nums.length];
            for (int j = i; j < nums.length; j++) {
                if (j== i) {
                    fi[j] = nums[i];
                } else {
                    fi[j] = fi[j - 1] + nums[j];
                }
                if (fi[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
