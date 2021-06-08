package com.company.leetcode.LinkNode;

public class easy_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead=new ListNode(0);
        ListNode prev=prehead;

        while(l1!=null && l2!=null)
        {
            if (l1.val<=l2.val)
            {
                prev.next=l1;
                l1=l1.next;
            }
            else
            {
                prev.next=l2;
                l2=l2.next;
            }
            prev=prev.next;
        }
        //合并完后，至多存在一个非空链表还没合并完，将prev指针指向非空链表即可
        prev.next=l1==null?l2:l1;
        return prehead.next;
    }
}
