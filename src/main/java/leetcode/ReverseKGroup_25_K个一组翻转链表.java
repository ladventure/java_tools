package leetcode;

import com.alibaba.fastjson.JSON;
import leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked
 * o(1) 空间复杂度
 */
public class ReverseKGroup_25_K个一组翻转链表 {
//    /**
//     * Definition for singly-linked list.
//     *  */
//    class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x) {
//            val = x;
//            next = null;
//        }
//    }
    public ListNode reverseKGroup(ListNode head, int k) {
//        1. 循环到 k 的倍数位置，然后从上次记录开始位置开始反转，反转到此为止
        if(k<=1){
            return head;
        }
//        给链表加一个头结点，方便处理
        ListNode start=new ListNode(0);
        start.next=head;
        ListNode cur=head;

        int count=0;
        while (cur!=null){
            ++count;
            cur=cur.next;
            if(count%k==0){
                //       start 需要等于第二次反转开始的前一个位置，
                //       cur 表示反转cur.next ,先摘掉节点，放到最前面
                ListNode subCur=start.next;
                ListNode nextStart=start.next;
                for (int i = 0; i < k-1; i++) {
                    ListNode tmp=subCur.next;
                    subCur.next=tmp.next;
                    tmp.next=start.next;
                    start.next=tmp;
                }
//               如果是第一次反转，需要更新head
                if(count==k){
                    head=start.next;
                }
                start=nextStart;

            }

        }

        return head;
    }



    @Test
    public void test(){
        System.out.println(JSON.toJSON(ListNode.convertList(reverseKGroup(ListNode.convertListNode(new int[]{1,2,3,4,5}),2))));

        System.out.println(JSON.toJSON(ListNode.convertList(reverseKGroup(ListNode.convertListNode(new int[]{1,2,3,4,5}),3))));

    }
}
