package leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import java.util.*;

public class Merge_56_合并区间 {
    /**
     * https://leetcode.cn/problems/merge-intervals/?envType=study-plan-v2&envId=top-100-liked
     * 思路：先对区间按照开始index进行排序，然后遍历区间，看看当前区间和前一个区间是否有交集，如果有交集，合并区间，否则，加入结果集。
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        List<int[]> merge = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        merge.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > (merge.get(merge.size() - 1))[1] && intervals[i][1] > (merge.get(merge.size() - 1))[1]) {
                merge.add(intervals[i]);
            }else {
                (merge.get(merge.size() - 1))[1]=Math.max((merge.get(merge.size() - 1))[1],intervals[i][1]);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }
    @Test
    public void test(){
//        merge_56_合并区间 merge_56_合并区间 = new merge_56_合并区间();
        System.out.println(JSON.toJSON(new Merge_56_合并区间().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
    }
}


