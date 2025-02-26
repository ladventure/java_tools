package leetcode;


/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/?envType=study-plan-v2&envId=top-100-liked
 * 快慢指针方法
 * 1. 找是否存在环，fast 移动两步，slow 移动一步，如果相遇，则存在环
 * 2. 找环开始节点，相遇的时候，将一个指针移动到开头，然后同步移动直到相遇就是环的起点。ps：通过走的路程数学计算得出的结论。
 */
public class DetectCycle_142_环形链表2 {
    /**
     * Definition for singly-linked list.
     *  */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode fast=head,slow=head;

        do {
            fast=fast.next.next;
            slow=slow.next;
        }while (fast!=slow && fast!=null && fast.next!=null);

//        无环
        if(fast!=slow){
            return null;
        }

        slow=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
