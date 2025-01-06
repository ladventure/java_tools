package leetcode;

/**
 * @author dylan.ll
 * @date 2020/10/30 20:50
 */
public class NumSub_1513 {
    public int numSub(String s) {
        int count=0;
        long tmp=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                tmp++;
            }else {
                count+= (int)(((tmp*(tmp+1)/2)%(Math.pow(10,9)+7)));
                tmp=0;
            }
        }
        count+= (int)(((tmp*(tmp+1)/2)%(Math.pow(10,9)+7)));
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumSub_1513().numSub("0110111"));
        System.out.println(new NumSub_1513().numSub("101"));
        System.out.println(new NumSub_1513().numSub("111111"));
        System.out.println(new NumSub_1513().numSub("000"));

    }
}
