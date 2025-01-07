package leetcode;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThreeSum_15_三数之和 {
    /**
     * 三数之和:https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-100-liked
     * 思路：双指针法，通过固定一个数字，其他两个数字通过双指针的方式进行查找
     * 1. 先排序
     * 2. 从中间可以选择，固定一个数字，固定数字记录不重复
     * 3. 双指针，一个从左往右，一个从右往左，找到符合条件的数字
     * 4. 最后给找到的结果去重一下
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
//        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int m=1;  m < nums.length-1;m++) {
            int i = m-1,j=m+1;
            while (i >= 0 && j<nums.length){
                if (nums[i] + nums[j] +nums[m]==0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[m]);
                    set.add(list.toString());
//                移动到下一个不重复的数字
                    i=moveToNext(nums,i,false);
                    j=moveToNext(nums,j,true);

                } else if (nums[i] + nums[j] + nums[m]<0) {
                    j=moveToNext(nums,j,true);
                }else {
                    i=moveToNext(nums,i,false);
                }
            }

        }

        return set.stream().map(s-> Arrays.stream(s.replace(" ","").replace("[","").replace("]","").split(",")).map(Integer::parseInt).collect(Collectors.toList())).collect(Collectors.toList());
    }

    private int moveToNext(int[] nums, int i, boolean plus) {
        int cur;
        do {
            if (plus){
                cur=i++;
            }else {
                cur=i--;
            }
        }while (i>=0 && i<nums.length && nums[i]==nums[cur]);

        return i;
    }

    @Test
    public void test(){
        int[] nums=new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));

        int[] nums2=new int[]{0,0,0,0};
        System.out.println(threeSum(nums2));

        int[] nums3=new int[]{-1,0,1,0};
        System.out.println(threeSum(nums3));
        int[] nums4=new int[]{1,2,-2,-1};
        System.out.println(threeSum(nums4));
        int[] nums5=new int[]{-1,0,1};
        System.out.println(threeSum(nums5));
    }
}
