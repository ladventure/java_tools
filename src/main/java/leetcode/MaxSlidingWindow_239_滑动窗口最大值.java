package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * https://leetcode.cn/problems/sliding-window-maximum/?envType=study-plan-v2&envId=top-100-liked
 */
public class MaxSlidingWindow_239_滑动窗口最大值 {

    /**
     * 单调队列，使用 priorityQueue 实现
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
//        保存的是窗口中的最大值，以及后续可能有用的，每次一次滑动窗口，都需要保证队列是单调递减的，队列头就是窗口最大的元素
//        由于每次都需要移除窗口前端的元素，所以有序队列里面存储索引更合适，
        Deque<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
//        构造窗口
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
        }
        res.add(nums[queue.peekFirst()]);
        for (int i = k; i < nums.length; i++) {

            if (!queue.isEmpty() && queue.peekFirst() <= i - k){
                queue.pollFirst();
            }

            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }


            queue.addLast(i);
            res.add(nums[queue.peekFirst()]);
        }


        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {

        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{7,2,4}, 2)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{9,10,9,-7,-4,-8,2,-6}, 5)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{-7,-8,7,5,7,1,6,0}, 4)));

        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));

    }
}
