package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dylan.ll
 * @date 2020/11/2 14:07
 */
public class Intersection_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list1 = getList(nums1);
        List<Integer> list2 = getList(nums2);
        Set<Integer> set = new HashSet<>();
        for (Integer one : list1) {
            if (list2.contains(one)) {
                set.add(one);
            }
        }

        int[] result = new int[set.size()];
        int i=0;
        for(Integer one:set){
            result[i++]=one;
        }
        return result;

    }

    public List<Integer> getList(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list1.add(nums[i]);
        }
        return list1;
    }
}
