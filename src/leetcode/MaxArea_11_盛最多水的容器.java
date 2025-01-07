package leetcode;

import org.junit.Test;

public class MaxArea_11_盛最多水的容器 {
    /**
     * https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-100-liked
     * 双指针法，从两端开始，每次移动
     **/
    public int maxArea(int[] height) {
        if (height.length<1){
            return 0;
        }
        int maxArea=0;
        for (int i = 0,j=height.length-1; i < j; ) {
            int curArea=(j-i)*Math.min(height[i],height[j]);
            maxArea=Math.max(maxArea,curArea);
            if (height[i]<height[j]){
                i++;
            }else {
                j--;
            }
        }
        return maxArea;
    }
    /**
     * https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=top-100-liked
     *
     * 遍历计算 area[i][j] 表示 i,j 之间的最大面积
     * area[i][j]=(j-i)*min(height[i],height[j])
     * O(n^2) 的时间复杂度，会超时，使用双指针法优化
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        if (height.length<1){
            return 0;
        }
//        遍历计算 area[i][j] 表示 i,j 之间的最大面积 。area[i][j]=(j-i)*min(height[i],height[j])
        int maxArea=0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int curArea=(j-i)*Math.min(height[i],height[j]);
                maxArea=Math.max(maxArea,curArea);
            }
        }
        return maxArea;
    }

    @Test
    public void test(){
        int[] height=new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
