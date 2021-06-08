package com.company.leetcode.LinkNode;

public class easy_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode p=head;
        StringBuilder sb=new StringBuilder();
        while(head!=null)
        {
            sb.append(head.val);
            head=head.next;
        }
        String str=sb.toString();
        for (int left=0,right=str.length()-1;left<right;left++,right--)
        {
            if (str.charAt(left)!=str.charAt(right))
            {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        if (head==null) return true;

        ListNode halfPre=medListNode(head);
        ListNode halfPost=reverseListNode(halfPre);

        ListNode pre=head;
        ListNode post=halfPost;

        while(post!=null)
        {
            if (pre.val!= post.val)
            {
                return false;
            }
            pre=pre.next;
            post=post.next;
        }
        return true;

    }

    private static ListNode reverseListNode(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null)
        {
            ListNode tmp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tmp;
        }
        return prev;
    }

    private static ListNode medListNode(ListNode head)
    {
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next !=null && fast.next.next !=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}