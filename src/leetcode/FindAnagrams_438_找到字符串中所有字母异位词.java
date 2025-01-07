package leetcode;

import org.junit.Test;

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
        Map<Character,Integer> pMap=new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i),pMap.getOrDefault(p.charAt(i),0)+1);
        }
        List<Integer> res=new ArrayList<>();
        for (int i = 0, j=0; i < s.length()-p.length()+1; ) {
            Map<Character,Integer>  tmpMap=new HashMap<>(pMap);

            while (!tmpMap.isEmpty()) {
//                如果当前字符不在p中，直接跳过已经匹配的，到下一个字符重新匹配
                if (!pMap.containsKey(s.charAt(i+j))){
                        i=i+j+1;
                        j=0;
                        break;
                }else {
                    /**
                     *  在的话，分两3种情况:
                     *
                     *  1. 如果tmpMap 中该字符还未消耗完，则消耗一个字符。
                     *      a. 然后判断是否找到一个子串，如果找到加入结果中，
                     *      b. 如果还未完成一个子串，表示还有子串的可能，继续匹配
                     *  2. 如果tmpMap 中该字符已经消耗完，则表示没有子串的可能，跳转到下一个字符重新匹配，已经匹配过的字符需要跳过
                     */
                    int num=tmpMap.getOrDefault(s.charAt(i+j),0);
                    if (num>=1){
                        if (num==1){
                            tmpMap.remove(s.charAt(i+j));
                        }else {
                            tmpMap.put(s.charAt(i+j),num-1);
                        }
                        j++;
                    }else {
//                      表示从 i+j 位置起不是 重置这个i+j位置
                        tmpMap.put(s.charAt(i),tmpMap.getOrDefault(s.charAt(i),0)+1);
                        i++;
                        j--;
                    }
                }

            }
            //                        判断是否找到一个子串
            if (tmpMap.isEmpty()){
                res.add(i);
                tmpMap.put(s.charAt(i),tmpMap.getOrDefault(s.charAt(i),0)+1);
            }



        }
        return res;
    }
    @Test
    public void test(){
//        System.out.println(findAnagrams("cbaebabacd","abc"));
        System.out.println(findAnagrams("abab","ab"));
    }
}
