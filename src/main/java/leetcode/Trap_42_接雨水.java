package leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Trap_42_接雨水 {
//    https://leetcode.cn/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-100-liked
    public int trap(int[] height) {
//       动态规划，fn 分为 hn 是否最大两种情况计算
        if (height.length<=2){
            return 0;
        }
        int[] res=new int[height.length];
        int curMaxIndex=0;
        if (height[1]>height[0]){
            curMaxIndex=1;
        }
        for (int i = 2; i < height.length; i++) {
            if(height[i]==0){
                res[i]=res[i-1];
                continue;
            }
//           找到前面大于等于当前高度的
            int betterIndex=i-1;
            for (; betterIndex >=0 && height[betterIndex]<height[i]; betterIndex--) {
            }
//            没找到，则取之前的最大值，并且更新最大值
            if (betterIndex<0){
                res[i]=res[curMaxIndex]+Math.max(0,i-curMaxIndex-1)*height[curMaxIndex];
                for (int j = curMaxIndex+1; j < i; j++) {
                    res[i]-=height[j];
                }
                curMaxIndex=i;
            }else {
//                找到了，则使用这个 betterIndex 和当前 i 位置进行动态规划计算当前 i 的值
                res[i]=res[betterIndex]+Math.max(0,i-betterIndex-1)*height[i];
                for (int j = betterIndex+1; j < i; j++) {
                    res[i]-=height[j];
                }


            }
        }

        return res[height.length-1];
    }

    @Test
    public void test(){
        int[] nums=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println( trap(nums));
        int[] nums2=new int[]{4,2,0,3,2,5};
        System.out.println( trap(nums2));
    }
}
