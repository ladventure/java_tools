package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutive_128_最长连续序列 {
    public int longestConsecutive(int[] nums) {
//        构建 hash 表，不断探测 x+1,x+2,x+3...
        Set<Integer> numsSet=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numsSet.add(nums[i]);
        }
        int max=0;

        for (int curNum : numsSet) {
            if (!numsSet.contains(curNum-1)){
                int tmpRes=1;
                while (numsSet.contains(curNum+1)) {
                    tmpRes++;
                    curNum++;
                }
                max=Math.max(max,tmpRes);
            }
        }

        return max;
    }

    @Test
    public void test(){
        int[] nums=new int[]{100,4,200,1,3,2};
        System.out.println( longestConsecutive(nums));

        int[] nums2=new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println( longestConsecutive(nums2));

        int[] nums3=new int[]{ 0,0,-1};
        System.out.println( longestConsecutive(nums3));


    }
}
