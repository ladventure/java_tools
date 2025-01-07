package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring_3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
//       动态规划+回溯法。利用动态规划记录当前位置最长不重复子串，回溯法更新子串内容一遍下一次动态规划计算使用
        if (s.length()<=1){
            return s.length();
        }
        int[] res=new int[s.length()];
        res[0]=1;
        int endInx=0;
        int maxLen=1;
        Set<Character> subSet=new HashSet<>();
        subSet.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if(endInx==i-1 && !subSet.contains(s.charAt(i))){
                res[i]=res[i-1]+1;
                endInx=i;
                maxLen=maxLen+1;
                subSet.add(s.charAt(i));
            }else if(endInx < i-1 && i-endInx>=maxLen || i==s.length()-1){
//              间隔子串已经大于等于当前最大子串再回溯，避免重复回溯
                int curInx=i-1;
                Set<Character> tmpSet=new HashSet<>();
                tmpSet.add(s.charAt(i));
                for (int j = i; j > 0 ; j--) {
                    tmpSet.add(s.charAt(j));
                    if (tmpSet.contains(s.charAt(j-1))){
                        break;
                    }
                }
                if (tmpSet.size()>maxLen){
                    maxLen=tmpSet.size();
                    endInx=i;
                    subSet=tmpSet;
                }

            }

        }
        return maxLen;
    }
    @Test
    public void test(){
//        String s="abcabcbb";
//        System.out.println(lengthOfLongestSubstring(s));
//        String s2="bbbbb";
//        System.out.println(lengthOfLongestSubstring(s2));
//        String s3="pwwkew";
//        System.out.println(lengthOfLongestSubstring(s3));
        String s4="anviaj";
        System.out.println(lengthOfLongestSubstring(s4));
    }
}
