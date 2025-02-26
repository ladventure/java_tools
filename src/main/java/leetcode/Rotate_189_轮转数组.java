package leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

public class Rotate_189_轮转数组 {
//    需要 o(1) 空间负责度，o(n) 时间，先让k取小于n 的值，计算从开始位置轮转之后的位置，然后跳到 k 位置移动，最后移动一轮，即可移动完成所有数字。
    public void rotate(int[] nums, int k) {

        if(k%nums.length==0){
            return;
        }

        int cur=0;
//        int next=k%nums.length;
        int curV=nums[0];
        for (int count = 0; count < nums.length; ) {
            int start=cur;
            do{
                int next=(cur+k)%nums.length;
                int tmp=nums[next];
                nums[next]=curV;
                curV=tmp;

                cur=next;
                count++;
            }while (cur!=start);

            cur=(cur+1)%nums.length;
            curV = nums[cur];
        }
    }

    @Test
    public void test(){
//        int[] nums=new int[]{1,2,3,4,5,6,7};
//        rotate(nums,3);
//        System.out.println(JSON.toJSON(nums));

        int[] nums2=new int[]{-1,-100,3,99};
        rotate(nums2,2);
        System.out.println(JSON.toJSON(nums2));
    }
}
