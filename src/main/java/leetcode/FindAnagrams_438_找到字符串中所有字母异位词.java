package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class FindAnagrams_438_找到字符串中所有字母异位词 {
    /**
     * https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked
     * 思路：类似查找所有子串，只是匹配方式不同，滑动窗口的方式进行。重点在于滑动时候的处理方式，需要跳过已经匹配过的字符
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length()<p.length()){
            return new ArrayList<>();
        }
        Map<Character,Integer> pMap=new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i),pMap.getOrDefault(p.charAt(i),0)+1);
        }
        List<Integer> res=new ArrayList<>();
        int windowSize=0;
        Map<Character,Integer>  winMap=new HashMap<>();

//        固定滑动窗口方案
        for (int i = 0; i < p.length()-1; i++) {
            winMap.put(s.charAt(i),winMap.getOrDefault(s.charAt(i),0)+1);
            windowSize++;
        }

        for (int i = 0; i < s.length()-p.length()+1; i++) {
            int curIndex=i+windowSize;
            winMap.put(s.charAt(curIndex),winMap.getOrDefault(s.charAt(curIndex),0)+1);
            if (Objects.deepEquals(winMap, pMap)) {
                res.add(i);
            }
            if (winMap.get(s.charAt(i)).equals(1)) {
                winMap.remove(s.charAt(i));
            } else {
                winMap.put(s.charAt(i), winMap.get(s.charAt(i)) - 1);
            }
        }
//        for (int i = 0, j=0; i < s.length()-p.length()+1; ) {
//            Map<Character,Integer>  tmpMap=new HashMap<>(pMap);
//
//            while (!tmpMap.isEmpty()) {
////                如果当前字符不在p中，直接跳过已经匹配的，到下一个字符重新匹配
//                if (!pMap.containsKey(s.charAt(i+j))){
//                        i=i+j+1;
//                        j=0;
//                        break;
//                }else {
//                    /**
//                     *  在的话，分两3种情况:
//                     *
//                     *  1. 如果tmpMap 中该字符还未消耗完，则消耗一个字符。
//                     *      a. 然后判断是否找到一个子串，如果找到加入结果中，
//                     *      b. 如果还未完成一个子串，表示还有子串的可能，继续匹配
//                     *  2. 如果tmpMap 中该字符已经消耗完，则表示没有子串的可能，跳转到下一个字符重新匹配，已经匹配过的字符需要跳过
//                     */
//                    int num=tmpMap.getOrDefault(s.charAt(i+j),0);
//                    if (num>=1){
//                        if (num==1){
//                            tmpMap.remove(s.charAt(i+j));
//                        }else {
//                            tmpMap.put(s.charAt(i+j),num-1);
//                        }
//                        j++;
//                    }else {
////                      表示从 i+j 位置起不是 重置这个i+j位置
//                        tmpMap.put(s.charAt(i),tmpMap.getOrDefault(s.charAt(i),0)+1);
//                        i++;
//                        j--;
//                    }
//                }
//
//            }
//            //                        判断是否找到一个子串
//            if (tmpMap.isEmpty()){
//                res.add(i);
//                tmpMap.put(s.charAt(i),tmpMap.getOrDefault(s.charAt(i),0)+1);
//            }
//
//
//
//        }
        return res;
    }


    /**
     * 可变滑动窗口方案，跳过一些窗口肯定不成立的场景
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        if (s.length()<p.length()){
            return new ArrayList<>();
        }
        Map<Character,Integer> pMap=new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i),pMap.getOrDefault(p.charAt(i),0)+1);
        }
        List<Integer> res=new ArrayList<>();
        int windowSize=0;
        Map<Character,Integer>  winMap=new HashMap<>();

        for (int i = 0; i < s.length()-p.length()+1; i++) {
            //   窗口构建集成到这里，可以跳过一些窗口肯定不成立的场景
            for (;windowSize<p.length()-1;windowSize++){
//                窗口构建时候也需要考虑不存在字符场景，
                if (!pMap.containsKey(s.charAt(i+windowSize))){
                    i=i+windowSize;
                    windowSize=0;
                    winMap.clear();
                    break;
                }
                winMap.put(s.charAt(i+windowSize),winMap.getOrDefault(s.charAt(i+windowSize),0)+1);
            }
            if (windowSize!=p.length()-1){
//                窗口未构建成功，直接跳过
                continue;
            }

            int curIndex=i+windowSize;
//            如果当前字符不在p中，直接跳过已经匹配的，到下一个字符重新匹配，通过下面代码会重建构建一个新的窗口
            if (!pMap.containsKey(s.charAt(curIndex))){
                i=curIndex;
                windowSize=0;
                winMap.clear();
                continue;
            }

            winMap.put(s.charAt(curIndex),winMap.getOrDefault(s.charAt(curIndex),0)+1);
            if (Objects.deepEquals(winMap, pMap)) {
                res.add(i);
            }
            if (winMap.get(s.charAt(i)).equals(1)) {
                winMap.remove(s.charAt(i));
            } else {
                winMap.put(s.charAt(i), winMap.get(s.charAt(i)) - 1);
            }
        }
        return res;
    }

    /**
     * 官方解法：
     * 基于可变滑动窗口方案，通过维护一个数组来记录窗口该位置字母次数差异，通过更新数组的 0 的个数来判断是否匹配，如果全部为 0 则表示匹配
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams3(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

            if (count[s.charAt(i + pLen) - 'a'] == -1) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];

            if (differ == 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(findAnagrams2("cbaebabacd","abc"));
        System.out.println(findAnagrams2("abab","ab"));
        System.out.println(findAnagrams2("aaaaaaaaaa","aaaaaaaaaaaaa"));
    }
}
