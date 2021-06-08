package com.company.leetcode.LinkNode;

import java.util.Stack;

public class med_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //双指针法：找待删除节点的前驱节点，删除该节点的后继节点即可
        ListNode fast=head;
        ListNode low=new ListNode(0,head);  //慢指针指向虚节点
        while (fast!=null && n-->0)
        {
            fast=fast.next;
        }

        while (fast!=null && low!=null)
        {
            low=low.next;
            fast=fast.next;
        }
        low.next=low.next.next;
        ListNode res=low.next;
        return res;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n)
    {
        Stack<ListNode> stack=new Stack<>();
        ListNode res=new ListNode(0,head);  //多声明一个虚节点，这样做的目的是，我们找的是待删除节点的前驱结点，如果删除的节点为头节点，那么这样做可以很好的删除头节点
        ListNode p=res;
        while (p!=null)
        {
            stack.push(p);
            p=p.next;
        }
        for (int i=0;i<n;i++)
        {
            stack.pop();
        }
        ListNode prev=stack.peek();  //上面多添加一个虚节点，也可以避免堆栈在弹出n个元素后为空的情况
        prev.next=prev.next.next;
        res=res.next;
        return res;
    }

}
