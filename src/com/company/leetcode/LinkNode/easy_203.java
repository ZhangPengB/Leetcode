package com.company.leetcode.LinkNode;

public class easy_203 {
    //找到待删除节点的前驱结点，然后删除
    public ListNode removeElements(ListNode head, int val) {
        if (head==null) return head;
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode p=dummyHead;
        while(p.next!=null)
        {
            if (p.next.val==val)
            {
                p.next=p.next.next;
            }
            else
            {
                p=p. next;
            }
        }
        return dummyHead.next;
    }
}
