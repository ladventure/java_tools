package leetcode;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-window-substring/?envType=study-plan-v2&envId=top-100-liked
 */
public class MinWindow_76_最小覆盖子串 {
    /**
     * 滑动窗口方案，通过双指针框定一个窗口
     * 1. 先移动前一个指针，找到一个包含 t 的子串
     * 2. 然后再移动后指针缩小窗口，找到最小的子串
     * 3. 然后同时移动指针，看是否能找打子串
     * 4. 重复2，3步骤，直到找到最小的子串
     * 5. 返回最小的子串
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
//        保存t的字符个数，value 为0个数确定是否是子串
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int diffCountZero = tMap.size() ;
        int left = 0, right = 0;
        int minLeft = 0, minRight = 0;
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> wMap = new HashMap<>(tMap);

        for (; right < s.length(); right++) {

//            构建窗口，更新窗口 right
            wMap.put(s.charAt(right), wMap.getOrDefault(s.charAt(right),0) - 1);
            if (wMap.get(s.charAt(right)).equals(0)) {
                diffCountZero--;
            }
//            找到子串，同步更新窗口 left到最小子串
            for (;diffCountZero == 0 && left<=right;left++) {

                wMap.put(s.charAt(left), wMap.getOrDefault(s.charAt(left), 0) + 1);
                if (wMap.get(s.charAt(left)).equals(1)) {
                    diffCountZero++;
                    if (right - left < minLength) {
                        minLeft = left;
                        minRight = right;
                        minLength = right - left;
                    }
                }
            }

        }

        if(minLength==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(minLeft, minRight+1 );
    }

    @Test
    public void test() {
//        System.out.println(minWindow("bba", "ab"));

//        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("aa", "aaa"));
    }
}
