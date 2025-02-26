package leetcode.common;


import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode convertListNode(int[] arr){
        if(arr.length==0){
            return null;
        }
        ListNode head=new ListNode(arr[0]);
        ListNode cur=head;

        for (int i = 1; i < arr.length; i++) {
            ListNode tmp=new ListNode(arr[i]);
            cur.next=tmp;
            cur=cur.next;
        }

        return head;
    }

    public static List<Integer> convertList(ListNode head){
        ListNode cur=head;
        List<Integer> list=new ArrayList<>();
        while (cur!=null){
            list.add(cur.val);
            cur=cur.next;
        }
        return list;
    }
}
