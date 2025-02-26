package leetcode;
import com.alibaba.fastjson.JSON;
import leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/?envType=study-plan-v2&envId=top-100-liked
 * @author dylan.ll
 * @date 2022/1/16 15:31
 * 合并有序链表，双指针法，
 * 1. 先找到最小的头结点，然后依次往后遍历，找到最小的节点，然后放到新链表中
 * 2. 重复1，直到所有链表都遍历完成
 */
public class MergeKLists_23_合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        ListNode head=lists[0];
        for (int i = 1; i < lists.length; i++) {
            head=merge(head,lists[i]);
        }
        return head;
    }

    /**
     * 合并两个有序链表
     * @param list1
     * @param list2
     */
    private ListNode merge(ListNode list1,ListNode list2){
        if(list1==null ){
            return list2;
        }
        if(list2==null ){
            return list1;
        }
        ListNode head=list1;
        ListNode list1Cur1=list1;
        ListNode list2Cur1=list2,list2Cur2=list2;
//        将开始位置大的链表合并到小的
        if(list2.val<list1.val){
            head=list2;
            list1Cur1=list2;
            list2Cur1=list1;
            list2Cur2=list1;
        }

        while (list1Cur1.next!=null && list2Cur2.next!=null){
            if(list1Cur1.next.val<=list2Cur1.val){
                list1Cur1=list1Cur1.next;
                continue;
            }

            if(list2Cur2.next.val<=list1Cur1.next.val){
                list2Cur2=list2Cur2.next;
            }else{
//                找到了，在 list1Cur1 后面插入 list2Cur1 到 list2Cur2
                ListNode nextTmp1=list1Cur1.next;
                list1Cur1.next=list2Cur1;
                ListNode nextTmp2=list2Cur2.next;
                list2Cur2.next=nextTmp1;
                list1Cur1=nextTmp1;
                list2Cur1=nextTmp2;
                list2Cur2=nextTmp2;
            }
        }
        if(list1Cur1.next==null){
            list1Cur1.next=list2Cur1;
        }else {
//            避免list2 因为到低退出，但是 list1 还没有来得及找到合适为止
            while (list1Cur1.next!=null && list1Cur1.next.val<=list2Cur1.val ){
                list1Cur1=list1Cur1.next;
            }
            list2Cur2.next= list1Cur1.next;
            list1Cur1.next=list2Cur1;
        }

        return head;
    }

    @Test
    public void test(){
        System.out.println(JSON.toJSON(
                ListNode.convertList(
                mergeKLists(new ListNode[]{
                        ListNode.convertListNode(new int[]{1,4,5}),
                        ListNode.convertListNode(new int[]{1,3,4}),
                        ListNode.convertListNode(new int[]{2,6}),
                }))));
    }
}
