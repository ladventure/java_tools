package leetcode;

import java.util.Objects;

/**
 * @author dylan.ll
 * @date 2020/7/14 15:53
 * 1513. 仅含 1 的子串数
 */
public class SubSub {
    public int numSub(String s) {
        long sum=0;
        long count=0;
        /**
         * 主要判断出 连续 1个个数，然后计算连续1 的子串个数，然后相加，连续n 个1 子串个数为（n+1）*n/2
         * @param s
         * @return
         */
        long BIG = 1000000000L + 7;
        for(int i = 0; i<s.length(); i++){
            if(Objects.equals(s.charAt(i),'1')){
                count++;
            }else {
                sum=(sum+(count*(count+1))/2)% BIG;
                count=0;
            }
        }
        sum=(sum+(count*(count+1))/2)% BIG;
        return (int)sum;
    }

    public static void main(String[] args) {
        System.out.println(new SubSub().numSub("0110111"));
        System.out.println(new SubSub().numSub("111111"));
        System.out.println(new SubSub().numSub("101"));

    }
}
