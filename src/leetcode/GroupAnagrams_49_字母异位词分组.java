package leetcode;

import org.junit.Test;

import java.util.*;

public class GroupAnagrams_49_字母异位词分组 {
    /**
     * https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked
     * 字母异位词，即是将给定的字符串数组根据是否是字母异位词进行分组，异位词是指由相同字母组成的单词，但是字母的顺序可能不同。
     * 思路：
     * 2. 使用哈希map来存储字符串字母以及出现次数，通过对比获取是否是异位词。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<Map<Character,Integer>> mapList=new ArrayList<>();
        List<List<String>> res=new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String curStr=strs[i];
//            构造异位词的map
            Map<Character,Integer> curMap=new HashMap<>();
            for (int j = 0; j < curStr.length(); j++) {
                curMap.put(curStr.charAt(j),curMap.getOrDefault(curStr.charAt(j),0)+1);
            }
//              遍历之前的map，判断是否是异位词
            int index=0;
            while (mapList.size()>index && !compareMap(curMap,mapList.get(index))){
                index++;
            }
            if (index==mapList.size()){
                mapList.add(curMap);
                List<String> curList=new ArrayList<>();
                curList.add(curStr);
                res.add(curList);
            }else {
                res.get(index).add(curStr);
            }

        }
        return res;
    }

    public boolean compareMap(Map<Character,Integer> map1,Map<Character,Integer> map2){
        if (map1.size()!=map2.size()){
            return false;
        }
        for (Character key:map1.keySet()) {
            if (!map2.containsKey(key) || !map2.get(key).equals(map1.get(key))){
                return false;
            }
        }
        return true;
    }
    @Test
    public void test(){
        String[] strs=new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));

    }
}
