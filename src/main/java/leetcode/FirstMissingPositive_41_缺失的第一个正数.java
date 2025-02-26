package leetcode;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.cn/problems/first-missing-positive/?envType=study-plan-v2&envId=top-100-liked
 * 通过将数组index 和 value 对应来实现，从1  开始，i 放在 i-1 的位置，如果 nums[i] > n,则肯定不是这个，除非找一遍都存在才会是 n
 */
public class FirstMissingPositive_41_缺失的第一个正数 {
    public int firstMissingPositive(int[] nums) {
        /**
         * 1. 从 nums 开始循环，通过这次循环，将正整数num[i]放入对应 i-1 的位置上，
         * 2. 通过遍历index 与 value ，比对第一个不相等的就是结果，如果找不到，最小就是 n
         */
        for (int i = 0; i < nums.length; ) {
            if(nums[i]<=0 || nums[i]==i+1 || nums[i]>nums.length || nums[nums[i]-1] == nums[i] ){
                i++;
                continue;
            }
//           否则 nums[nums[i]-1] = nums[i]交换一下，并且继续从 i 开始循环
            int tmp=nums[nums[i]-1];
            nums[nums[i]-1]=nums[i];
            nums[i]=tmp;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    @Test
    public void test(){
        System.out.println(firstMissingPositive(new int[]{1}));
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));

    }
}
